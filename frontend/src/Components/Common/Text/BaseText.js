import React from "react";
import { useTranslation } from "react-i18next";

export default function BaseText(props) {
  const { content, handleClick, ...restProps } = props;
  const { t, i18n } = useTranslation();
  return (
    <span onClick={handleClick} {...restProps}>
      {t(content)}
    </span>
  );
}
