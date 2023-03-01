import React, { forwardRef, useState, useImperativeHandle } from "react";
import {
  ModalHeader,
  ModalBody,
  Label,
  ModalFooter,
  Modal,
  Button,
} from "reactstrap";

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
          <Button
            color="light"
            onClick={() => {
              setModal(false);
            }}
          >
            Close
          </Button>
          <Button color="primary" onClick={props.onClickSubmit}>
            Save changes
          </Button>
        </div>
      </ModalFooter>
    </Modal>
  );
};

export default forwardRef(BaseModal);
