<script>
import Layout from "../../layouts/main.vue";
import PageHeader from "@/components/page-header";
import appConfig from "../../../app.config";
import JobWidgets from "./components/job-widgets.vue";
import FeaturedCompanies from "./components/featured-companies.vue";
import ApplicationsStatistic from "./components/applications-statistic.vue";
import RecomendedJobs from "./components/recomended-jobs.vue";
import RecentApplicants from "./components/recent-applicants.vue";

export default {
  page: {
    title: "Dashboard",
    meta: [{ name: "description", content: appConfig.description }],
  },
  data() {
    return {
      title: "Dashboard",
      items: [
        {
          text: "Dashboards",
          href: "/",
        },
        {
          text: "Dashboard",
          active: true,
        },
      ],
    };
  },
  components: {
    Layout,
    PageHeader,
    JobWidgets,
    FeaturedCompanies,
    ApplicationsStatistic,
    RecomendedJobs,
    RecentApplicants
  },
};
</script>

<template>
  <Layout>
    <PageHeader :title="title" :items="items" />

    <b-row>
      <JobWidgets />
      <FeaturedCompanies />
    </b-row>

    <ApplicationsStatistic />

    <RecomendedJobs />

    <RecentApplicants />
  </Layout>
</template>