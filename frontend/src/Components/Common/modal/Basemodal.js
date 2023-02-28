import React, { forwardRef, useState, useImperativeHandle } from "react";
import {
  ModalHeader,
  ModalBody,
  Label,
  ModalFooter,
  Modal,
  Form,
} from "reactstrap";
import PropTypes from "prop-types";

const BaseModal = (props, ref) => {
  const [modal, setModal] = useState(false);

  useImperativeHandle(ref, () => ({
    toggle,
  }));

  const toggle = () => {
    setModal(!modal);
  };
  return (
    <Modal
      id="showModal"
      isOpen={modal}
      toggle={toggle}
      size="xl"
      className="modal-fullscreen"
      modalClassName="fadeInRight"
    >
      {props.isHeader && (
        <ModalHeader className="bg-light p-3" toggle={toggle}>
          {props.title}
        </ModalHeader>
      )}
      <div className="side-panel-labels" onClick={toggle}>
        <div className="side-panel-label">
          <div className="side-panel-label-icon-box">
            <button
              type="button"
              className="btn-close float-end fs-11"
              aria-label="Close"
            ></button>
          </div>
        </div>
      </div>

      <ModalBody>{props.children}</ModalBody>
      <ModalFooter>
        <div className="hstack gap-2 justify-content-end">
          <button
            type="button"
            className="btn btn-light"
            onClick={() => {
              setModal(false);
            }}
          >
            {" "}
            Close{" "}
          </button>
          <button type="submit" className="btn btn-success" id="add-btn">
            {"Tạo form"}
          </button>
        </div>
      </ModalFooter>
    </Modal>
  );
};

// BaseModal.propTypes = {
//   isHeader: PropTypes.bool,
//   title: PropTypes.string,
//   children: PropTypes.node.isRequired,
//   // onClickSubmit: PropTypes.func.isRequired
// };

export default forwardRef(BaseModal);
