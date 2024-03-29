import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const Navdata = () => {
  const history = useNavigate();
  //state data
  const [isDashboard, setIsDashboard] = useState(false);
  const [isManagerProduct, setIsManagerProduct] = useState(false);
  const [isUsers, setIsUsers] = useState(false);
  const [isCrm, setIsCrm] = useState(false);
  const [isAuth, setIsAuth] = useState(false);
  const [isPages, setIsPages] = useState(false);
  const [isBaseUi, setIsBaseUi] = useState(false);
  const [isAdvanceUi, setIsAdvanceUi] = useState(false);
  const [isForms, setIsForms] = useState(false);
  const [isTables, setIsTables] = useState(false);
  const [isCharts, setIsCharts] = useState(false);
  const [isIcons, setIsIcons] = useState(false);
  const [isMaps, setIsMaps] = useState(false);
  const [isMultiLevel, setIsMultiLevel] = useState(false);

  // Apps
  const [isEmail, setEmail] = useState(false);
  const [isSubEmail, setSubEmail] = useState(false);
  const [isEcommerce, setIsEcommerce] = useState(false);
  const [isProjects, setIsProjects] = useState(false);
  const [isTasks, setIsTasks] = useState(false);
  const [isCRM, setIsCRM] = useState(false);
  const [isCrypto, setIsCrypto] = useState(false);
  const [isInvoices, setIsInvoices] = useState(false);
  const [isSupportTickets, setIsSupportTickets] = useState(false);
  const [isNFTMarketplace, setIsNFTMarketplace] = useState(false);
  const [isJobs, setIsJobs] = useState(false);
  const [isJobList, setIsJobList] = useState(false);
  const [isCandidateList, setIsCandidateList] = useState(false);

  // Authentication
  const [isSignIn, setIsSignIn] = useState(false);
  const [isSignUp, setIsSignUp] = useState(false);
  const [isPasswordReset, setIsPasswordReset] = useState(false);
  const [isPasswordCreate, setIsPasswordCreate] = useState(false);
  const [isLockScreen, setIsLockScreen] = useState(false);
  const [isLogout, setIsLogout] = useState(false);
  const [isSuccessMessage, setIsSuccessMessage] = useState(false);
  const [isVerification, setIsVerification] = useState(false);
  const [isError, setIsError] = useState(false);

  // Pages
  const [isProfile, setIsProfile] = useState(false);
  const [isLanding, setIsLanding] = useState(false);

  // Charts
  const [isApex, setIsApex] = useState(false);

  // Multi Level
  const [isLevel1, setIsLevel1] = useState(false);
  const [isLevel2, setIsLevel2] = useState(false);

  const [iscurrentState, setIscurrentState] = useState("Dashboard");

  function updateIconSidebar(e) {
    if (e && e.target && e.target.getAttribute("subitems")) {
      const ul = document.getElementById("two-column-menu");
      const iconItems = ul.querySelectorAll(".nav-icon.active");
      let activeIconItems = [...iconItems];
      activeIconItems.forEach((item) => {
        item.classList.remove("active");
        var id = item.getAttribute("subitems");
        if (document.getElementById(id))
          document.getElementById(id).classList.remove("show");
      });
    }
  }

  useEffect(() => {
    document.body.classList.remove("twocolumn-panel");
    if (iscurrentState !== "Dashboard") {
      setIsDashboard(false);
    }
    if (iscurrentState !== "ProductionManager") {
      setIsManagerProduct(false);
    }
    if (iscurrentState !== "HRM") {
      setIsUsers(false);
    }
    if (iscurrentState !== "CRM") {
      setIsCRM(false);
    }
    if (iscurrentState !== "Auth") {
      setIsAuth(false);
    }
    if (iscurrentState !== "Pages") {
      setIsPages(false);
    }
    if (iscurrentState !== "BaseUi") {
      setIsBaseUi(false);
    }
    if (iscurrentState !== "AdvanceUi") {
      setIsAdvanceUi(false);
    }
    if (iscurrentState !== "Forms") {
      setIsForms(false);
    }
    if (iscurrentState !== "Tables") {
      setIsTables(false);
    }
    if (iscurrentState !== "Charts") {
      setIsCharts(false);
    }
    if (iscurrentState !== "Icons") {
      setIsIcons(false);
    }
    if (iscurrentState !== "Maps") {
      setIsMaps(false);
    }
    if (iscurrentState !== "MuliLevel") {
      setIsMultiLevel(false);
    }
    if (iscurrentState === "Widgets") {
      history("/widgets");
      document.body.classList.add("twocolumn-panel");
    }
    if (iscurrentState !== "Landing") {
      setIsLanding(false);
    }
  }, [
    history,
    iscurrentState,
    isDashboard,
    isManagerProduct,
    isUsers,
    isCRM,
    isAuth,
    isPages,
    isBaseUi,
    isAdvanceUi,
    isForms,
    isTables,
    isCharts,
    isIcons,
    isMaps,
    isMultiLevel,
  ]);

  const menuItems = [
    {
      label: "Menu",
      isHeader: true,
    },
    {
      id: "dashboard",
      label: "Dashboards",
      icon: "bx bxs-dashboard",
      link: "/#",
      stateVariables: isDashboard,
      click: function (e) {
        e.preventDefault();
        setIsDashboard(!isDashboard);
        setIscurrentState("Dashboard");
        updateIconSidebar(e);
      },
    },
    {
      id: "production-manager",
      label: "Production Manager",
      icon: "bx bx-layer",
      link: "/#",
      click: function (e) {
        e.preventDefault();
        setIsManagerProduct(!isManagerProduct);
        setIscurrentState("ProductionManager");
        updateIconSidebar(e);
      },
      stateVariables: isManagerProduct,
      subItems: [
        {
          id: "machines-manager",
          label: "Machines Manager",
          link: "/machines-manager",
          parentId: "production-manager",
        },
        {
          id: "supplies-manager",
          label: "Supplies Manager",
          link: "/supplies-manager",
          parentId: "production-manager",
        },
        {
          id: "supplier-manager",
          label: "Supplier Manager",
          link: "/supplier-manager",
          parentId: "production-manager",
        },
        {
          id: "factory-manager",
          label: "Factory Manager",
          link: "/factory-manager",
          parentId: "production-manager",
        },
      ],
    },
    {
      id: "hrm",
      label: "HRM",
      icon: "bx bx-user-circle",
      link: "/#",
      click: function (e) {
        e.preventDefault();
        setIsUsers(!isUsers);
        setIscurrentState("HRM");
        updateIconSidebar(e);
      },
      stateVariables: isUsers,
      subItems: [
        {
          id: "user",
          label: "User",
          link: "/user",
          parentId: "hrm",
        },
      ],
    },
    {
      id: "crm",
      label: "CRM",
      icon: "bx bx-user-circle",
      link: "/#",
      click: function (e) {
        e.preventDefault();
        setIsCRM(!isCrm);
        setIscurrentState("CRM");
        updateIconSidebar(e);
      },
      stateVariables: isCrm,
      subItems: [
        {
          id: "deals",
          label: "Deals",
          link: "/deals",
          parentId: "crm",
        },
        {
          id: "leads",
          label: "Leads",
          link: "/leads",
          parentId: "crm",
        },
        {
          id: "companies",
          label: "Companies",
          link: "/companies",
          parentId: "crm",
        },
        {
          id: "contacts",
          label: "Contacts",
          link: "/contacts",
          parentId: "crm",
        },
      ],
    },
  ];
  return <React.Fragment>{menuItems}</React.Fragment>;
};
export default Navdata;
