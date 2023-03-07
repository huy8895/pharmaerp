import { all, fork } from "redux-saga/effects";
//Auth
import AccountSaga from "./auth/register/saga";
import AuthSaga from "./auth/login/saga";
import ForgetSaga from "./auth/forgetpwd/saga";
import ProfileSaga from "./auth/profile/saga";

import LayoutSaga from "./layouts/saga";
import chatSaga from "./backup/chat/saga";
import projectSaga from "./backup/projects/saga";
import taskSaga from "./backup/tasks/saga";
import cryptoSaga from "./backup/crypto/saga";
import ticketsSaga from "./backup/tickets/saga";
import calendarSaga from "./backup/calendar/saga";
import ecommerceSaga from "./backup/ecommerce/saga";
import crmSaga from "./crm/saga";
import invoiceSaga from "./backup/invoice/saga";
import dashboardAnalyticsSaga from "./backup/dashboardAnalytics/saga";
import dashboardCrmSaga from "./backup/dashboardCRM/saga";
import dashboardEcommerceSaga from "./backup/dashboardEcommerce/saga";
import dashboardCryptoSaga from "./backup/dashboardCrypto/saga";
import dashboardProjectSaga from "./backup/dashboardProject/saga";
import dashboardNFTSaga from "./backup/dashboardNFT/saga";
import teamSaga from "./backup/team/saga";
import fileManager from "./backup/fileManager/saga";
import todos from "./backup/todos/saga";
import ApplicationSaga from "./backup/job/saga";
import APIKeysaga from "./backup/apikey/saga";
export default function* rootSaga() {
  yield all([
    //public
    fork(LayoutSaga),
    fork(AccountSaga),
    fork(AuthSaga),
    fork(ForgetSaga),
    fork(ProfileSaga),
    fork(chatSaga),
    fork(projectSaga),
    fork(taskSaga),
    fork(cryptoSaga),
    fork(ticketsSaga),
    fork(calendarSaga),
    fork(ecommerceSaga),
    fork(crmSaga),
    fork(invoiceSaga),
    fork(dashboardAnalyticsSaga),
    fork(dashboardCrmSaga),
    fork(dashboardEcommerceSaga),
    fork(dashboardCryptoSaga),
    fork(dashboardProjectSaga),
    fork(dashboardNFTSaga),
    fork(teamSaga),
    fork(fileManager),
    fork(todos),
    fork(ApplicationSaga),
    fork(APIKeysaga),
  ]);
}
