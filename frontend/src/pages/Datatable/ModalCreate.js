import BaseDate from "Components/Common/form/BaseDate";
import BaseForm from "Components/Common/form/BaseForm";
import BaseSelect from "Components/Common/form/BaseSelect";
import BaseModal from "Components/Common/modal/BaseModal";
import { FormikProvider, useFormik } from "formik";
import React, {
  useRef,
  useState,
  forwardRef,
  useImperativeHandle,
} from "react";
import { Col, Input, Row } from "reactstrap";
import * as moment from "moment";
import * as Yup from "yup";

const dataSelect = [
  { label: "Exiting", value: "Exiting" },
  { label: "Lead", value: "Lead" },
  { label: "Long-term", value: "Long-term" },
  { label: "Partner", value: "Partner" },
];

const ModalCreate = (props, ref) => {
  const {lead} = props;
  const showModalRef = useRef(null);
  const [tag, setTag] = useState();

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
      // if (isEdit) {
      //   const updateLead = {
      //     _id: lead ? lead._id : 0,
      //     // img: values.img,
      //     name: values.name,
      //     company: values.company,
      //     score: values.score,
      //     phone: values.phone,
      //     location: values.location,
      //     date: values.date,
      //     tags: values.tags,
      //   };
      //   // update Company
      //   dispatch(onUpdateLead(updateLead));
      //   validation.resetForm();
      // } else {
      //   const newLead = {
      //     _id: (Math.floor(Math.random() * (30 - 20)) + 20).toString(),
      //     // img: values["img"],
      //     name: values["name"],
      //     company: values["company"],
      //     score: values["score"],
      //     phone: values["phone"],
      //     location: values["location"],
      //     date: values.date,
      //     tags: values.tags,
      //   };
      //   // save new Lead
      //   dispatch(onAddNewLead(newLead));
      //   validation.resetForm();
      // }
      showModalRef.current.toggle();
    },
  });

  useImperativeHandle(ref, () => ({
    showModal,
  }));

  const showModal = () => {
    showModalRef.current.toggle();
    validation.resetForm();
  };

  const onClickSubmit = (e) => {
    e.preventDefault();
    validation.handleSubmit();
    return false;
  };

  function handlestag(tag) {
    setTag(tag);
    validation.setFieldValue("tags", tag.value);
  }

  const dateformate = (e) => {
    const date = moment(e[0]).format("DD-MM-YYYY");
    validation.setFieldValue("date", date);
  };

  return (
    <BaseModal
      ref={showModalRef}
      onClickSubmit={onClickSubmit}
      isFullScreen
      modalClassName="fadeInRight"
    >
      <FormikProvider value={validation}>
        <Input type="hidden" id="id-field" />
        <Row className="g-3">
          <Col lg={12}>
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
              options={dataSelect}
              handleChange={handlestag}
              msgerror={validation.errors.tags}
            />
          </Col>
          <Col lg={12}>
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
  );
};

export default forwardRef(ModalCreate);
