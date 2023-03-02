import React, {
  useEffect,
  useState,
  useCallback,
  useMemo,
  useRef,
} from "react";
import { Link } from "react-router-dom";
import {
  Col,
  Container,
  Row,
  Card,
  CardHeader,
  CardBody,
  Input,
  ModalHeader,
  ModalBody,
  Label,
  ModalFooter,
  Modal,
  Form,
  UncontrolledDropdown,
  DropdownToggle,
  DropdownMenu,
  DropdownItem,
  FormFeedback,
} from "reactstrap";
import Select from "react-select";
import Flatpickr from "react-flatpickr";
import * as moment from "moment";

import BreadCrumb from "Components/Common/BreadCrumb";
import { isEmpty } from "lodash";

// Import Images
import dummyImg from "assets/images/users/user-dummy-img.jpg";

//Import actions
import {
  getLeads as onGetLeads,
  addNewLead as onAddNewLead,
  updateLead as onUpdateLead,
  deleteLead as onDeleteLead,
} from "store/backup/crm/action";

//redux
import { useSelector, useDispatch } from "react-redux";
import TableContainer from "Components/Common/TableContainer";
import DeleteModal from "Components/Common/DeleteModal";
import ItemTable from "./ItemTable";

// Formik
import * as Yup from "yup";
import { FormikProvider, useFormik } from "formik";

import Loader from "Components/Common/Loader";
import { toast, ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import BaseModal from "Components/Common/modal/BaseModal";
import BaseForm from "Components/Common/form/BaseForm";
import BaseSelect from "Components/Common/form/BaseSelect";
import BaseDate from "Components/Common/form/BaseDate";

const CrmLeads = () => {
  const dispatch = useDispatch();
  const { leads, isLeadCreated, isLeadsSuccess, error } = useSelector(
    (state) => ({
      leads: state.Crm.leads,
      isLeadCreated: state.Crm.isLeadCreated,
      isLeadsSuccess: state.Crm.isLeadsSuccess,
      error: state.Crm.error,
    })
  );

  const showFormRef = useRef(null);

  useEffect(() => {
    if (leads && !leads.length) {
      dispatch(onGetLeads());
    }
  }, [dispatch, leads]);

  useEffect(() => {
    setLead(leads);
  }, [leads]);

  useEffect(() => {
    if (!isEmpty(leads)) {
      setLead(leads);
      setIsEdit(false);
    }
  }, [leads]);

  const [isEdit, setIsEdit] = useState(false);
  const [lead, setLead] = useState([]);

  //delete lead
  const [deleteModal, setDeleteModal] = useState(false);
  const [deleteModalMulti, setDeleteModalMulti] = useState(false);

  const [modal, setModal] = useState(false);

  const [isInfoDetails, setIsInfoDetails] = useState(false);

  const [tag, setTag] = useState([]);

  function handlestag(tag) {
    setTag(tag);
    validation.setFieldValue("tags", tag.value);
  }

  const tags = [
    { label: "Exiting", value: "Exiting" },
    { label: "Lead", value: "Lead" },
    { label: "Long-term", value: "Long-term" },
    { label: "Partner", value: "Partner" },
  ];

  const onClickSubmit = (e) => {
    e.preventDefault();
    validation.handleSubmit();
    return false;
  };

  const toggle = useCallback(() => {
    if (modal) {
      setModal(false);
      setLead(null);
    } else {
      setModal(true);
      setTag([]);
    }
  }, [modal]);

  // Delete Data
  const handleDeleteLead = () => {
    if (lead) {
      dispatch(onDeleteLead(lead._id));
      setDeleteModal(false);
    }
  };

  const onClickDelete = (lead) => {
    setLead(lead);
    setDeleteModal(true);
  };

  // Add Data
  const handleLeadClicks = () => {
    setLead("");
    setIsEdit(false);
    toggle();
  };

  const toggleInfo = () => {
    setIsInfoDetails(!isInfoDetails);
  };

  // validation
  const validation = useFormik({
    // enableReinitialize : use this flag when initial values needs to be changed
    enableReinitialize: true,

    initialValues: {
      // img: (lead && lead.img) || '',
      name: (lead && lead.name) || "",
      company: (lead && lead.company) || "",
      score: (lead && lead.score) || "",
      phone: (lead && lead.phone) || "",
      location: (lead && lead.location) || "",
      date: (lead && lead.date) || "",
      tags: (lead && lead.tags) || "",
    },
    validationSchema: Yup.object({
      name: Yup.string().required("Please Enter Name"),
      company: Yup.string().required("Please Enter Company"),
      score: Yup.string().required("Please Enter Score"),
      phone: Yup.string().required("Please Enter Phone"),
      location: Yup.string().required("Please Enter Location"),
      tags: Yup.string().required("Please Enter Date"),
      date: Yup.string().required("Please Enter Date"),
    }),
    onSubmit: (values) => {
      if (isEdit) {
        const updateLead = {
          _id: lead ? lead._id : 0,
          // img: values.img,
          name: values.name,
          company: values.company,
          score: values.score,
          phone: values.phone,
          location: values.location,
          date: values.date,
          tags: values.tags,
        };
        // update Company
        dispatch(onUpdateLead(updateLead));
        validation.resetForm();
      } else {
        const newLead = {
          _id: (Math.floor(Math.random() * (30 - 20)) + 20).toString(),
          // img: values["img"],
          name: values["name"],
          company: values["company"],
          score: values["score"],
          phone: values["phone"],
          location: values["location"],
          date: values.date,
          tags: values.tags,
        };
        // save new Lead
        dispatch(onAddNewLead(newLead));
        validation.resetForm();
      }
    },
  });

  // Update Data
  const handleLeadClick = useCallback(
    (arg) => {
      const lead = arg;

      setLead({
        _id: lead._id,
        // img: lead.img,
        name: lead.name,
        company: lead.company,
        score: lead.score,
        phone: lead.phone,
        location: lead.location,
        date: lead.date,
        tags: lead.tags,
      });

      // Node API
      // useEffect(() => {
      //   if (isLeadCreated) {
      //     setLead(null);
      //     dispatch(onGetLeads());
      //   }
      // }, [
      //   dispatch,
      //   isLeadCreated,
      // ]);

      setIsEdit(true);
      toggle();
    },
    [toggle]
  );

  const handleValidDate = (date) => {
    const date1 = moment(new Date(date)).format("DD MMM Y");
    return date1;
  };

  // Checked All
  const checkedAll = useCallback(() => {
    const checkall = document.getElementById("checkBoxAll");
    const ele = document.querySelectorAll(".leadsCheckBox");

    if (checkall.checked) {
      ele.forEach((ele) => {
        ele.checked = true;
      });
    } else {
      ele.forEach((ele) => {
        ele.checked = false;
      });
    }
    deleteCheckbox();
  }, []);

  // Delete Multiple
  const [selectedCheckBoxDelete, setSelectedCheckBoxDelete] = useState([]);
  const [isMultiDeleteButton, setIsMultiDeleteButton] = useState(false);

  const deleteMultiple = () => {
    const checkall = document.getElementById("checkBoxAll");
    selectedCheckBoxDelete.forEach((element) => {
      dispatch(onDeleteLead(element.value));
      setTimeout(() => {
        toast.clearWaitingQueue();
      }, 3000);
    });
    setIsMultiDeleteButton(false);
    checkall.checked = false;
  };

  const deleteCheckbox = () => {
    const ele = document.querySelectorAll(".leadsCheckBox:checked");
    ele.length > 0
      ? setIsMultiDeleteButton(true)
      : setIsMultiDeleteButton(false);
    setSelectedCheckBoxDelete(ele);
  };

  // Customber Column
  const columns = useMemo(
    () => [
      {
        Header: (
          <input
            type="checkbox"
            id="checkBoxAll"
            className="form-check-input"
            onClick={() => checkedAll()}
          />
        ),
        Cell: (cellProps) => {
          return (
            <input
              type="checkbox"
              className="leadsCheckBox form-check-input"
              value={cellProps.row.original._id}
              onChange={() => deleteCheckbox()}
            />
          );
        },
        id: "#",
      },
      {
        Header: "Name",
        accessor: "name",
        filterable: false,
        Cell: (leads) => (
          <>
            <div className="d-flex align-items-center">
              <div className="flex-shrink-0">
                {
                  leads.row.original.image_src ? (
                    <img
                      src={
                        process.env.REACT_APP_API_URL +
                        "/images/users/" +
                        leads.row.original.image_src
                      }
                      alt=""
                      className="avatar-xxs rounded-circle"
                    />
                  ) : (
                    <div className="flex-shrink-0 avatar-xs me-2">
                      <div className="avatar-title bg-soft-success text-success rounded-circle fs-13">
                        {leads.row.original.name.charAt(0)}
                      </div>
                    </div>
                  )
                  // <img src={dummyImg} alt="" className="avatar-xxs rounded-circle" />
                }
              </div>
              <div className="flex-grow-1 ms-2 name">
                {leads.row.original.name}
              </div>
            </div>
          </>
        ),
      },
      {
        Header: "Company",
        accessor: "company",
        filterable: false,
      },
      {
        Header: "Leads Score",
        accessor: "score",
        filterable: false,
      },
      {
        Header: "Phone",
        accessor: "phone",
        filterable: false,
      },
      {
        Header: "Location",
        accessor: "location",
        filterable: false,
      },
      {
        Header: "Tags",
        Cell: (leads) => (
          <>
            <span className="badge badge-soft-primary me-1">
              {leads.row.original.tags}
            </span>
          </>
        ),
      },
      {
        Header: "Create Date",
        accessor: "date",
        filterable: false,
        Cell: (cell) => <>{handleValidDate(cell.value)}</>,
      },
      {
        Header: "Action",
        Cell: (cellProps) => {
          return (
            <ul className="list-inline hstack gap-2 mb-0">
              <li className="list-inline-item edit" title="Call">
                <Link
                  to="#"
                  className="text-muted d-inline-block"
                  // onClick={toggle}
                >
                  <i className="ri-phone-line fs-16"></i>
                </Link>
              </li>
              <li className="list-inline-item edit" title="Message">
                <Link to="#" className="text-muted d-inline-block">
                  <i className="ri-question-answer-line fs-16"></i>
                </Link>
              </li>
              <li className="list-inline-item" title="View">
                <Link to="#">
                  <i className="ri-eye-fill align-bottom text-muted"></i>
                </Link>
              </li>
              <li className="list-inline-item" title="Edit">
                <Link
                  className="edit-item-btn"
                  to="#"
                  onClick={() => {
                    const LeadData = cellProps.row.original;
                    handleLeadClick(LeadData);
                  }}
                >
                  <i className="ri-pencil-fill align-bottom text-muted"></i>
                </Link>
              </li>
              <li className="list-inline-item" title="Delete">
                <Link
                  className="remove-item-btn"
                  onClick={() => {
                    const LeadData = cellProps.row.original;
                    onClickDelete(LeadData);
                  }}
                  to="#"
                >
                  <i className="ri-delete-bin-fill align-bottom text-muted"></i>
                </Link>
              </li>
            </ul>
          );
        },
      },
    ],
    [handleLeadClick, checkedAll]
  );

  const dateformate = (e) => {
    const date = moment(e[0]).format("DD-MM-YYYY");
    validation.setFieldValue("date", date);
  };

  document.title = "Khánh Louis";
  return (
    <React.Fragment>
      <div className="page-content">
        <DeleteModal
          show={deleteModal}
          onDeleteClick={handleDeleteLead}
          onCloseClick={() => setDeleteModal(false)}
        />
        <DeleteModal
          show={deleteModalMulti}
          onDeleteClick={() => {
            deleteMultiple();
            setDeleteModalMulti(false);
          }}
          onCloseClick={() => setDeleteModalMulti(false)}
        />

        <Container fluid>
          <BreadCrumb title="Leads" pageTitle="CRM" />
          <Row>
            <Col lg={12}>
              <Card id="leadsList">
                <CardHeader className="border-0">
                  <Row className="g-4 align-items-center">
                    <Col sm={3}>
                      <div className="search-box">
                        <Input
                          type="text"
                          className="form-control search"
                          placeholder="Search for..."
                        />
                        <i className="ri-search-line search-icon"></i>
                      </div>
                    </Col>
                    <div className="col-sm-auto ms-auto">
                      <div className="hstack gap-2">
                        {isMultiDeleteButton && (
                          <button
                            className="btn btn-soft-danger"
                            onClick={() => setDeleteModalMulti(true)}
                          >
                            <i className="ri-delete-bin-2-line"></i>
                          </button>
                        )}
                        <button
                          type="button"
                          className="btn btn-info"
                          onClick={toggleInfo}
                        >
                          <i className="ri-filter-3-line align-bottom me-1"></i>{" "}
                          Fliters
                        </button>
                        <button
                          type="button"
                          className="btn btn-success add-btn"
                          id="create-btn"
                          onClick={() => {
                            // setIsEdit(false);
                            // toggle();
                            showFormRef.current.toggle();
                            validation.resetForm();
                          }}
                        >
                          <i className="ri-add-line align-bottom me-1"></i> Add
                          Leads
                        </button>
                        <UncontrolledDropdown>
                          <DropdownToggle
                            className="btn btn-soft-secondary btn-icon fs-14"
                            type="button"
                            id="dropdownMenuButton1"
                            data-bs-toggle="dropdown"
                            aria-expanded="false"
                          >
                            <i className="ri-settings-4-line"></i>
                          </DropdownToggle>
                          <DropdownMenu>
                            <li>
                              <DropdownItem>Copy</DropdownItem>
                            </li>
                            <li>
                              <DropdownItem>Move to pipline</DropdownItem>
                            </li>
                            <li>
                              <DropdownItem>Add to exceptions</DropdownItem>
                            </li>
                            <li>
                              <DropdownItem>
                                Switch to common form view
                              </DropdownItem>
                            </li>
                            <li>
                              <DropdownItem>
                                Reset form view to default
                              </DropdownItem>
                            </li>
                          </DropdownMenu>
                        </UncontrolledDropdown>
                      </div>
                    </div>
                  </Row>
                </CardHeader>
                <CardBody className="pt-0">
                  <div>
                    {isLeadsSuccess && leads.length ? (
                      <TableContainer
                        columns={columns}
                        data={leads || []}
                        isGlobalFilter={false}
                        isAddUserList={false}
                        customPageSize={10}
                        className="custom-header-css"
                        divClass="table-responsive table-card mb-0"
                        tableClass="align-middle table-nowrap"
                        theadClass="text-muted"
                        handleLeadClick={handleLeadClicks}
                        isLeadsFilter={false}
                      />
                    ) : (
                      <Loader error={error} />
                    )}
                  </div>

                  <BaseModal ref={showFormRef} onClickSubmit={onClickSubmit}>
                    <FormikProvider value={validation}>
                      <Input type="hidden" id="id-field" />
                      <Row className="g-3">
                        <Col lg={12}>
                          <div className="text-center">
                            <div className="position-relative d-inline-block">
                              <div className="position-absolute bottom-0 end-0">
                                <Label
                                  htmlFor="lead-image-input"
                                  className="mb-0"
                                >
                                  <div className="avatar-xs cursor-pointer">
                                    <div className="avatar-title bg-light border rounded-circle text-muted">
                                      <i className="ri-image-fill"></i>
                                    </div>
                                  </div>
                                </Label>
                                <Input
                                  className="form-control d-none"
                                  id="lead-image-input"
                                  type="file"
                                  accept="image/png, image/gif, image/jpeg"
                                  onChange={validation.handleChange}
                                  onBlur={validation.handleBlur}
                                  value={validation.values.img || ""}
                                  invalid={
                                    validation.touched.img &&
                                    validation.errors.img
                                      ? true
                                      : false
                                  }
                                />
                              </div>
                              <div className="avatar-lg p-1">
                                <div className="avatar-title bg-light rounded-circle">
                                  <img
                                    src={dummyImg}
                                    alt="dummyImg"
                                    id="lead-img"
                                    className="avatar-md rounded-circle object-cover"
                                  />
                                </div>
                              </div>
                            </div>
                            <h5 className="fs-13 mt-3">Lead Image</h5>
                          </div>
                          <BaseForm
                            id="customername-field"
                            name="name"
                            title="Name"
                            placeholder="Nhập name"
                            msgerror={validation.errors.name}
                          />
                        </Col>
                        <Col lg={12}>
                          <BaseForm
                            id="company_name-field"
                            name="company"
                            title="Company"
                            placeholder="Enter Company Name"
                            msgerror={validation.errors.company}
                          />
                        </Col>
                        <Col lg={6}>
                          <BaseForm
                            id="score-field"
                            name="score"
                            title="Score"
                            placeholder="Enter score Name"
                            msgerror={validation.errors.score}
                          />
                        </Col>
                        <Col lg={6}>
                          <BaseForm
                            id="phone-field"
                            name="phone"
                            title="Phone"
                            placeholder="Enter phone Name"
                            msgerror={validation.errors.phone}
                          />
                        </Col>
                        <Col lg={12}>
                          <BaseForm
                            id="location-field"
                            name="location"
                            title="Location"
                            placeholder="Enter location Name"
                            msgerror={validation.errors.location}
                          />
                        </Col>
                        <Col lg={12}>
                          <BaseSelect
                            id="taginput-choices"
                            name="tags"
                            title="Tags"
                            value={tag}
                            options={tags}
                            handleChange={handlestag}
                            msgerror={validation.errors.tags}
                          />
                        </Col>
                        <Col lg={12}>
                          {/* <div>
                            <Label htmlFor="date-field" className="form-label">
                              Created Date
                            </Label>

                            <Flatpickr
                              name="date"
                              id="datepicker-publish-input"
                              className="form-control"
                              placeholder="Select a date"
                              options={{
                                // altInput: true,
                                // altFormat: "d M, Y",
                                dateFormat: "d-m-Y",
                                locale: "vn"
                              }}
                              onChange={(e) => dateformate(e)}
                              value={validation.values.date || ""}
                            />
                            {validation.touched.date &&
                            validation.errors.date ? (
                              <FormFeedback type="invalid">
                                {validation.errors.date}
                              </FormFeedback>
                            ) : null}
                          </div> */}
                          <BaseDate
                            name="date"
                            title="Date"
                            id="datepicker-publish-input"
                            placeholder="Select a date"
                            value={validation.values.date || ""}
                            msgerror={validation.errors.date}
                            handleChange={dateformate}
                          />
                        </Col>
                      </Row>
                    </FormikProvider>
                  </BaseModal>
                  <ToastContainer closeButton={false} limit={1} />
                </CardBody>
              </Card>
            </Col>
          </Row>
        </Container>
      </div>

      <ItemTable
        show={isInfoDetails}
        onCloseClick={() => setIsInfoDetails(false)}
      />
    </React.Fragment>
  );
};

export default CrmLeads;
