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
import { Col, Input, Label, Row } from "reactstrap";
import * as moment from "moment";
import * as Yup from "yup";

import dummyImg from "assets/images/users/user-dummy-img.jpg";

const dataSelect = [
    { label: "fulltime", value: "Full Time" },
    { label: "parttime", value: "Part Time" },
    { label: "freelance", value: "Freelance" },
    { label: "Partner", value: "Partner" },
  ];

const ModalCreateCandidate = (props, ref) => {

  const showModalRef = useRef(null);
  const [tag, setTag] = useState();

  const formik = useFormik({
    // enableReinitialize : use this flag when initial values needs to be changed
    enableReinitialize: true,

    initialValues: {
        nickname: '',
        userImg: '',
        candidateName: "",
        designation:  "",
        location:  "",
        type: "",
        rating: "",
        bookmark: "",
    },
    validationSchema: Yup.object({
        userImg: Yup.string().required("Please Enter Name"),
        candidateName: Yup.string().required("Please Enter Company"),
        designation: Yup.string().required("Please Enter Score"),
        location: Yup.string().required("Please Enter Phone"),
        type: Yup.string().required("Please Enter Location"),
        rating: Yup.string().required("Please Enter Date"),
        bookmark: Yup.string().required("Please Enter Date"),
    }),
    onSubmit: (values) => {
    //   if (isEdit) {
    //     const updateLead = {
    //       _id: lead ? lead._id : 0,
    //       // img: values.img,
    //       name: values.name,
    //       company: values.company,
    //       score: values.score,
    //       phone: values.phone,
    //       location: values.location,
    //       date: values.date,
    //       tags: values.tags,
    //     };
    //     // update Company
    //     dispatch(onUpdateLead(updateLead));
    //     formik.resetForm();
    //   } else {
    //     const newLead = {
    //       _id: (Math.floor(Math.random() * (30 - 20)) + 20).toString(),
    //       // img: values["img"],
    //       name: values["name"],
    //       company: values["company"],
    //       score: values["score"],
    //       phone: values["phone"],
    //       location: values["location"],
    //       date: values.date,
    //       tags: values.tags,
    //     };
    //     // save new Lead
    //     dispatch(onAddNewLead(newLead));
    //     formik.resetForm();
    //   }
    //   showFormRef.current.showModal();
    },
  });

  useImperativeHandle(ref, () => ({
    showModal,
  }));

  const showModal = () => {
    showModalRef.current.toggle();
    formik.resetForm();
  };

  const onClickSubmit = (e) => {
    e.preventDefault();
    formik.handleSubmit();
    return false;
  };

  const onChangeAvatar = (e) => {
    console.log('e#####: ', e.target);

  }

  return (
    <BaseModal title="Add Candidate" ref={showModalRef} onClickSubmit={onClickSubmit} centered={true} >
      <FormikProvider value={formik}>
        <Input type="hidden" id="id-field" />
        <Row className="g-3">
          <Col>
            <div className="text-center">
              <div className="position-relative d-inline-block">
                <div className="position-absolute bottom-0 end-0">
                  <Label htmlFor="lead-image-input" className="mb-0">
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
                    onChange={onChangeAvatar}
                    onBlur={formik.handleBlur}
                    value={formik.values.userImg || ""}
                    invalid={
                      formik.touched.userImg && formik.errors.userImg
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
              <h5 className="fs-13 mt-3">Avatar</h5>
            </div>
          </Col>
          <Col lg={12}>
            <BaseForm
              id="candidate-name-field"
              name="candidateName"
              title="Candidate Name"
              placeholder="Nhập Candidate"
              msgerror={formik.errors.candidateName}
            />
          </Col>
          <Col lg={12}>
            <BaseForm
              id="designation-field"
              name="designation"
              title="Designation"
              placeholder="Enter designation"
              msgerror={formik.errors.designation}
            />
          </Col>
          <Col lg={12}>
            <BaseForm
              id="location-field"
              name="location"
              title="Location"
              placeholder="Enter location Name"
              msgerror={formik.errors.location}
            />
          </Col>
        </Row>
      </FormikProvider>
    </BaseModal>
  );
};

export default forwardRef(ModalCreateCandidate);
