import { combineReducers } from "redux";

// Front
import Layout from "./layouts/reducer";

// Authentication
import Login from "./auth/login/reducer";
import Account from "./auth/register/reducer";
import ForgetPassword from "./auth/forgetpwd/reducer";
import Profile from "./auth/profile/reducer";

//Calendar
import Calendar from "./backup/calendar/reducer";
//Chat
import chat from "./backup/chat/reducer";
//Ecommerce
import Ecommerce from "./backup/ecommerce/reducer";

//Project
import Projects from "./backup/projects/reducer";

// Tasks
import Tasks from "./backup/tasks/reducer";
//Form advanced
import changeNumber from "./backup/formAdvanced/reducer";

//Crypto
import Crypto from "./backup/crypto/reducer";

//TicketsList
import Tickets from "./backup/tickets/reducer";
//Crm
import Crm from "./crm/reducer";

//Invoice
import Invoice from "./backup/invoice/reducer";

//Mailbox
import Mailbox from "./backup/mailbox/reducer";

// Dashboard Analytics
import DashboardAnalytics from "./backup/dashboardAnalytics/reducer";

// Dashboard CRM
import DashboardCRM from "./backup/dashboardCRM/reducer";

// Dashboard Ecommerce
import DashboardEcommerce from "./backup/dashboardEcommerce/reducer";

// Dashboard Cryto
import DashboardCrypto from "./backup/dashboardCrypto/reducer";

// Dashboard Cryto
import DashboardProject from "./backup/dashboardProject/reducer";

// Dashboard NFT
import DashboardNFT from "./backup/dashboardNFT/reducer";

// Pages > Team
import Team from "./backup/team/reducer";

// File Manager
import FileManager from "./backup/fileManager/reducer";

// To do
import Todos from "./backup/todos/reducer";
//Jobs
import Jobs from "./backup/job/reducer";
//API Key
import APIKey from "./backup/apikey/reducer";
const rootReducer = combineReducers({
  // public
  Layout,
  Login,
  Account,
  ForgetPassword,
  Profile,
  Calendar,
  chat,
  Projects,
  Ecommerce,
  Tasks,
  changeNumber,
  Crypto,
  Tickets,
  Crm,
  Invoice,
  Mailbox,
  DashboardAnalytics,
  DashboardCRM,
  DashboardEcommerce,
  DashboardCrypto,
  DashboardProject,
  DashboardNFT,
  Team,
  FileManager,
  Todos,
  Jobs,
  APIKey,
});

export default rootReducer;
