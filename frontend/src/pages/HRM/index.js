import React, { useRef } from "react";
import { NavLink, Link } from "react-router-dom";
import { Card, CardBody, Col, Container, Input, Row } from "reactstrap";
import Select from "react-select";
import { jobCandidates } from "common/data/appsJobs";
import BreadCrumb from "Components/Common/BreadCrumb";
import { useTranslation } from "react-i18next";
import ItemFilterHRM from "./ItemFilterHRM";
import withRouter from "Components/Common/withRouter";
import ModalCreateCandidate from "./ModalCreateCandidate";

const CandidateGrid = (props) => {
  const { t } = useTranslation();
  const showFilterCandidate = useRef(null);

  const modalCandidateRef = useRef(null);
  const sortbyname = [
    {
      options: [
        { label: "All", value: "All" },
        { label: "Today", value: "Today" },
        { label: "Yesterday", value: "Yesterday" },
        { label: "Last 7 Days", value: "Last 7 Days" },
        { label: "Last 30 Days", value: "Last 30 Days" },
        { label: "Thise Month", value: "Thise Month" },
        { label: "Last Year", value: "Last Year" },
      ],
    },
  ];

  const toggleInfo = () => {
    showFilterCandidate.current.showModalRef();
  };

  const onClickDetailProfile = () => {
    props.router.navigate("/pages-profile");
  };

  const onClickShowModalAdd = () => {
    modalCandidateRef.current.showModal();
  };

  document.title =
    "Candidates Grid View | Velzon -  Admin & Dashboard Template";
  return (
    <React.Fragment>
      <div className="page-content">
        <Container fluid>
          <BreadCrumb title="Grid View" pageTitle="Candidates Grid" />

          <Row className="g-4 mb-4">
            <Col sm="auto">
              <div>
                <button
                  className="btn btn-success"
                  onClick={onClickShowModalAdd}
                >
                  <i className="ri-add-line align-bottom me-1"></i>{" "}
                  {t("Add Candidate")}
                </button>
              </div>
            </Col>
            <Col className="col-sm">
              <div className="d-md-flex justify-content-sm-end gap-2">
                <div className="search-box ms-md-2 flex-shrink-0 mb-3 mb-md-0">
                  <Input
                    type="text"
                    className="form-control"
                    id="searchJob"
                    autoComplete="off"
                    placeholder="Search for candidate name or designation..."
                  />
                  <i className="ri-search-line search-icon"></i>
                </div>

                <button
                  type="button"
                  className="btn btn-info"
                  onClick={toggleInfo}
                >
                  <i className="ri-filter-3-line align-bottom me-1"></i>{" "}
                  {t("Filter")}
                </button>
              </div>
            </Col>
          </Row>

          <Row className="gy-2 mb-2" id="candidate-list">
            {jobCandidates.map((item, key) => (
              <Col xxl={3} md={6} key={key}>
                <Card>
                  <CardBody onClick={onClickDetailProfile}>
                    <div className="d-flex align-items-center">
                      <div className="flex-shrink-0">
                        {item.userImg ? (
                          <div className="avatar-lg rounded">
                            <img
                              src={item.userImg}
                              alt=""
                              className="member-img img-fluid d-block rounded"
                            ></img>
                          </div>
                        ) : (
                          <div className="avatar-lg rounded">
                            <div className="avatar-title border bg-light text-primary rounded text-uppercase fs-24">
                              {item.nickname}
                            </div>
                          </div>
                        )}
                      </div>
                      <div className="flex-grow-1 ms-3">
                        <h5 className="fs-16 mb-1">{item.candidateName}</h5>
                        <p className="text-muted mb-2">{item.designation}</p>
                        <div className="d-flex flex-wrap gap-2 align-items-center">
                          <div className="badge text-bg-success">
                            <i className="mdi mdi-star me-1"></i>
                            {item.rating[0]}
                          </div>
                          <div className="text-muted">{item.rating[1]}</div>
                        </div>
                        <div className="d-flex gap-4 mt-2 text-muted">
                          <div>
                            <i className="ri-map-pin-2-line text-primary me-1 align-bottom"></i>{" "}
                            {item.location}
                          </div>
                          <div>
                            <i className="ri-time-line text-primary me-1 align-bottom"></i>
                            <span
                              className={"badge badge-soft-" + item.type[1]}
                            >
                              {item.type[0]}
                            </span>
                          </div>
                        </div>
                      </div>
                    </div>
                  </CardBody>
                </Card>
              </Col>
            ))}
          </Row>

          <Row className="g-0 justify-content-end mb-4" id="pagination-element">
            <Col sm={6}>
              <div className="pagination-block pagination pagination-separated justify-content-center justify-content-sm-end mb-sm-0">
                <div className="page-item">
                  <Link to="" className="page-link" id="page-prev">
                    Previous
                  </Link>
                </div>
                <span id="page-num" className="pagination"></span>
                <div className="page-item">
                  <Link to="" className="page-link" id="page-next">
                    Next
                  </Link>
                </div>
              </div>
            </Col>
          </Row>
        </Container>
        <ModalCreateCandidate ref={modalCandidateRef} />
        <ItemFilterHRM ref={showFilterCandidate} />
      </div>
    </React.Fragment>
  );
};

export default withRouter(CandidateGrid);
