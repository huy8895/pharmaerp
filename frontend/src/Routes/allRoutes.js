import React from "react";
import { Navigate } from "react-router-dom";

//Dashboard

//login
import DashboardCrm from "pages/Dashboard";
import Logout from "pages/Authentication/Logout";
import Login from "pages/Authentication/Login";
import Register from "pages/Authentication/Register";
import ForgetPasswordPage from "pages/Authentication/ForgetPassword";
import Chat from "pages/backup/Chat";
import Datatable from "pages/Datatable";

const authProtectedRoutes = [
  { path: "/dashboard", component: <DashboardCrm /> },
  { path: "/apps-table", component: <Datatable /> },

  // this route should be at the end of all other routes
  // eslint-disable-next-line react/display-name
  {
    path: "/",
    exact: true,
    component: <Navigate to="/dashboard" />,
  },
  { path: "*", component: <Navigate to="/dashboard" /> },
];

const publicRoutes = [
  // Authentication Page
  { path: "/logout", component: <Logout /> },
  { path: "/login", component: <Login /> },
  { path: "/forgot-password", component: <ForgetPasswordPage /> },
  { path: "/register", component: <Register /> },
];

export { authProtectedRoutes, publicRoutes };
