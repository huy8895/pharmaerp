import React, { forwardRef, useState, useImperativeHandle } from "react";
import {
  ModalHeader,
  ModalBody,
  Label,
  ModalFooter,
  Modal,
  Button,
} from "reactstrap";
import { useTranslation } from "react-i18next";

const BaseModal = (props, ref) => {
  const { id, title, modalClassName, size, isFullScreen } = props;
  const [modal, setModal] = useState(false);
  const { t, i18n } = useTranslation();

  useImperativeHandle(ref, () => ({
    toggle,
  }));

  const toggle = () => {
    setModal(!modal);
  };
  return (
    <Modal
      id={id}
      isOpen={modal}
      toggle={toggle}
      size={size || "lg"}
      className={isFullScreen ? "modal-fullscreen" : ""}
      modalClassName={modalClassName || "fadeInUp"}
      {...props}
    >
      {!isFullScreen && (
        <ModalHeader className="bg-soft-info p-3" toggle={toggle}>
          {t(title)}
        </ModalHeader>
      )}
      {isFullScreen && (
        <div className="side-panel-labels" onClick={toggle}>
          <div className="side-panel-label">
            <div className="side-panel-label-icon-box">
              <button
                type="button"
                className="btn-close btn-close-white float-end fs-11"
                aria-label="Close"
              ></button>
            </div>
          </div>
        </div>
      )}

      <ModalBody>{props.children}</ModalBody>
      <ModalFooter>
        <div className="hstack gap-2 justify-content-end">
          <Button
            color="light"
            onClick={() => {
              setModal(false);
            }}
          >
            {t("Close")}
          </Button>
          <Button color="primary" onClick={props.onClickSubmit}>
            {t("Save changes")}
          </Button>
        </div>
      </ModalFooter>
    </Modal>
  );
};

export default forwardRef(BaseModal);
