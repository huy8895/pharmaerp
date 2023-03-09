import React, { useState, forwardRef, useImperativeHandle } from "react";
import { useTranslation } from "react-i18next";
import { Offcanvas, OffcanvasHeader, OffcanvasBody } from "reactstrap";

const BaseFilter = (props, ref) => {
  const { t } = useTranslation();
  const { title } = props;

  const [isShow, setIsShow] = useState(false);

  useImperativeHandle(ref, () => ({
    showFilter,
  }));

  const showFilter = () => {
    setIsShow(!isShow);
  };
  const onCloseClick = () => {
    setIsShow(false);
  };
  return (
    <Offcanvas
      direction="end"
      isOpen={isShow}
      id="offcanvasExample"
      toggle={onCloseClick}
    >
      <OffcanvasHeader className="bg-light" toggle={onCloseClick}>
        {t(title)}
      </OffcanvasHeader>
      <form action="" className="d-flex flex-column justify-content-end h-100">
        <OffcanvasBody>{props.children}</OffcanvasBody>
        <div className="offcanvas-footer border-top p-3 text-center hstack gap-2">
          <div className="btn btn-light w-100" onClick={onCloseClick}>
            {t("Clear Filter")}
          </div>
          <button
            type="submit"
            className="btn btn-success w-100"
            onClick={onCloseClick}
          >
            {t("Filter")}
          </button>
        </div>
      </form>
    </Offcanvas>
  );
};

export default forwardRef(BaseFilter);
