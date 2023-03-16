/*
 Navicat Premium Data Transfer

 Source Server         : PgConnect
 Source Server Type    : PostgreSQL
 Source Server Version : 140005
 Source Host           : localhost:5432
 Source Catalog        : postgres

 Target Server Type    : PostgreSQL
 Target Server Version : 140005
 File Encoding         : 65001

 Date: 26/02/2023 15:03:08
*/

-- ----------------------------
-- Table structure for setting_themes
-- ----------------------------
DROP TABLE IF EXISTS "setting_themes";
CREATE TABLE "setting_themes"
(
    "id"            bigserial                                  NOT NULL,
    "user_id"       int8                                       NOT NULL,
    "layout"        varchar(20) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'vertical',
    "color_scheme"  varchar(20) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'light',
    "topbar_color"  varchar(20) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'light',
    "sidebar_color" varchar(20) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'light',
    "sidebar_img"   varchar(20) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'none',
    "preloader"     varchar(20) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'enable',
    "created_at"    timestamp(6),
    "updated_at"    timestamp(6),
    "deleted_at"    timestamp(6)
)
;

COMMENT ON COLUMN "setting_themes"."layout" is 'vertical,horizontal,twocolumn; 3 giá trị này phải là lowercase';
COMMENT ON COLUMN "setting_themes"."color_scheme" is 'light,dark; 2 giá trị này phải là lowercase';
COMMENT ON COLUMN "setting_themes"."topbar_color" is 'light,dark; 2 giá trị này phải là lowercase';
COMMENT ON COLUMN "setting_themes"."sidebar_color" is 'light,dark,gradient; 3 giá trị này phải là lowercase';
COMMENT ON COLUMN "setting_themes"."sidebar_img" is 'none,img-1,img-2,img-3,img-4,img-n; n giá trị này phải là lowercase; ảnh là có sẵn';
COMMENT ON COLUMN "setting_themes"."preloader" is 'enable,disable; 2 giá trị này phải là lowercase';

-- ----------------------------
-- Table structure for activity_logs
-- ----------------------------
DROP TABLE IF EXISTS "activity_logs";
CREATE TABLE "activity_logs"
(
    "id"         bigserial                                  NOT NULL,
    "user_id"    int8,
    "ip"         varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
    "user_agent" text COLLATE "pg_catalog"."default",
    "request"    text COLLATE "pg_catalog"."default",
    "response"   text COLLATE "pg_catalog"."default",
    "created_at" timestamp(6),
    "updated_at" timestamp(6),
    "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for contract_types
-- ----------------------------
DROP TABLE IF EXISTS "contract_types";
CREATE TABLE "contract_types"
(
    "id"                    bigserial                                   NOT NULL,
    "name_vi"               varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
    "name_en"               varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
    "is_determine_deadline" boolean                                     NOT NULL DEFAULT false,
    "is_active"             boolean                                     NOT NULL DEFAULT true,
    "describe"              text COLLATE "pg_catalog"."default",
    "created_at"            timestamp(6),
    "updated_at"            timestamp(6),
    "deleted_at"            timestamp(6)
)
;

-- ----------------------------
-- Table structure for contracts
-- ----------------------------
DROP TABLE IF EXISTS "contracts";
CREATE TABLE "contracts"
(
    "id"                   bigserial                                  NOT NULL,
    "user_id"              int8                                       NOT NULL,
    "creator_id"           int8                                       NOT NULL,
    "contract_type_id"     int8                                       NOT NULL,
    "gen_work_location_id" int8                                       NOT NULL,
    "gen_officer_level_id" int8                                       NOT NULL,
    "gen_department_id"    int8                                       NOT NULL,
    "gen_job_title_id"     int8                                       NOT NULL,
    "contract_code"        varchar(45) COLLATE "pg_catalog"."default" NOT NULL,
    "duration"             int8,
    "start_date"           date,
    "end_date"             date,
    "status"               varchar(45) COLLATE "pg_catalog"."default" NOT NULL,
    "note"                 text COLLATE "pg_catalog"."default",
    "created_at"           timestamp(6),
    "updated_at"           timestamp(6),
    "deleted_at"           timestamp(6)
)
;

COMMENT ON COLUMN "contracts"."status" is 'Draft, To confirm, To review, Approved, Running, Pending, Expired, Liquidated, Rejected\nDự thảo, để xác nhận, xem xét, phê duyệt, chạy, chờ xử lý, hết hạn, bị thanh lý, bị từ chối';

-- ----------------------------
-- Table structure for gen_departments
-- ----------------------------
DROP TABLE IF EXISTS "gen_departments";
CREATE TABLE "gen_departments"
(
    "id"         bigserial                                   NOT NULL,
    "name_vi"    varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
    "name_en"    varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
    "describe"   text COLLATE "pg_catalog"."default",
    "is_active"  boolean                                     NOT NULL DEFAULT true,
    "created_at" timestamp(6),
    "updated_at" timestamp(6),
    "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for gen_job_titles
-- ----------------------------
DROP TABLE IF EXISTS "gen_job_titles";
CREATE TABLE "gen_job_titles"
(
    "id"         bigserial                                   NOT NULL,
    "name_vi"    varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
    "name_en"    varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
    "salary"     int8,
    "describe"   text COLLATE "pg_catalog"."default",
    "is_active"  boolean                                     NOT NULL DEFAULT true,
    "created_at" timestamp(6),
    "updated_at" timestamp(6),
    "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for gen_officer_levels
-- ----------------------------
DROP TABLE IF EXISTS "gen_officer_levels";
CREATE TABLE "gen_officer_levels"
(
    "id"         bigserial                                   NOT NULL,
    "name_vi"    varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
    "name_en"    varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
    "describe"   text COLLATE "pg_catalog"."default",
    "is_active"  boolean                                     NOT NULL DEFAULT true,
    "created_at" timestamp(6),
    "updated_at" timestamp(6),
    "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for gen_uploads
-- ----------------------------
DROP TABLE IF EXISTS "gen_uploads";
CREATE TABLE "gen_uploads"
(
    "id"            bigserial                                   NOT NULL,
    "original_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
    "file_name"     varchar(45) COLLATE "pg_catalog"."default"  NOT NULL,
    "extension"     varchar(10) COLLATE "pg_catalog"."default"  NOT NULL,
    "content_type"  varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
    "data"          bytea                                       NOT NULL,
    "size"          float4                                      NOT NULL,
    "created_at"    timestamp(6),
    "updated_at"    timestamp(6),
    "deleted_at"    timestamp(6)
)
;

-- ----------------------------
-- Table structure for gen_work_locations
-- ----------------------------
DROP TABLE IF EXISTS "gen_work_locations";
CREATE TABLE "gen_work_locations"
(
    "id"         bigserial                                   NOT NULL,
    "name_vi"    varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
    "name_en"    varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
    "describe"   text COLLATE "pg_catalog"."default",
    "is_active"  boolean                                     NOT NULL DEFAULT true,
    "created_at" timestamp(6),
    "updated_at" timestamp(6),
    "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS "permissions";
CREATE TABLE "permissions"
(
    "id"         bigserial                                   NOT NULL,
    "group"      varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
    "key"        varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
    "is_active"  boolean                                     NOT NULL DEFAULT true,
    "created_at" timestamp(6),
    "updated_at" timestamp(6),
    "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS "roles";
CREATE TABLE "roles"
(
    "id"         bigserial                                   NOT NULL,
    "name_vi"    varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
    "name_en"    varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
    "describe"   text COLLATE "pg_catalog"."default",
    "is_default" boolean                                     NOT NULL DEFAULT false,
    "is_active"  boolean                                     NOT NULL DEFAULT true,
    "created_at" timestamp(6),
    "updated_at" timestamp(6),
    "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS "roles_permissions";
CREATE TABLE "roles_permissions"
(
    "role_id"       int8 NOT NULL,
    "permission_id" int8 NOT NULL
)
;

-- ----------------------------
-- Table structure for uploadables
-- ----------------------------
DROP TABLE IF EXISTS "uploadables";
CREATE TABLE "uploadables"
(
    "gen_upload_id" int8 NOT NULL,
    "object_id"     int8 NOT NULL,
    "object_type"   varchar(45) COLLATE "pg_catalog"."default",
    "object_field"  varchar(45) COLLATE "pg_catalog"."default",
    "describe"      text COLLATE "pg_catalog"."default"
)
;

COMMENT ON COLUMN "uploadables"."object_id" is 'ID of reference object';
COMMENT ON COLUMN "uploadables"."object_type" is 'table name of reference object';
COMMENT ON COLUMN "uploadables"."object_field" is 'field name of reference object. Ex: logo, avatar, ...';

-- ----------------------------
-- Table structure for user_activities
-- ----------------------------
DROP TABLE IF EXISTS "user_activities";
CREATE TABLE "user_activities"
(
    "id"                     bigserial                                   NOT NULL,
    "user_id"                int8                                        NOT NULL,
    "organization"           varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
    "participating_position" varchar(255) COLLATE "pg_catalog"."default",
    "is_current_active"      boolean DEFAULT false,
    "start_date"             varchar(45) COLLATE "pg_catalog"."default",
    "end_date"               varchar(45) COLLATE "pg_catalog"."default",
    "describe"               text COLLATE "pg_catalog"."default",
    "link"                   varchar(255) COLLATE "pg_catalog"."default",
    "created_at"             timestamp(6),
    "updated_at"             timestamp(6),
    "deleted_at"             timestamp(6)
)
;

-- ----------------------------
-- Table structure for user_certificates
-- ----------------------------
DROP TABLE IF EXISTS "user_certificates";
CREATE TABLE "user_certificates"
(
    "id"                     bigserial                                   NOT NULL,
    "user_id"                int8                                        NOT NULL,
    "name"                   varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
    "organization"           varchar(255) COLLATE "pg_catalog"."default",
    "has_no_expiration_date" boolean DEFAULT true,
    "start_date"             varchar(45) COLLATE "pg_catalog"."default",
    "end_date"               varchar(45) COLLATE "pg_catalog"."default",
    "link"                   varchar(255) COLLATE "pg_catalog"."default",
    "created_at"             timestamp(6),
    "updated_at"             timestamp(6),
    "deleted_at"             timestamp(6)
)
;

-- ----------------------------
-- Table structure for user_courses
-- ----------------------------
DROP TABLE IF EXISTS "user_courses";
CREATE TABLE "user_courses"
(
    "id"           bigserial                                   NOT NULL,
    "user_id"      int8                                        NOT NULL,
    "name"         varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
    "organization" varchar(255) COLLATE "pg_catalog"."default",
    "start_date"   varchar(45) COLLATE "pg_catalog"."default",
    "end_date"     varchar(45) COLLATE "pg_catalog"."default",
    "describe"     text COLLATE "pg_catalog"."default",
    "link"         varchar(255) COLLATE "pg_catalog"."default",
    "created_at"   timestamp(6),
    "updated_at"   timestamp(6),
    "deleted_at"   timestamp(6)
)
;

-- ----------------------------
-- Table structure for user_profiles
-- ----------------------------
DROP TABLE IF EXISTS "user_profiles";
CREATE TABLE "user_profiles"
(
    "id"                     bigserial NOT NULL,
    "user_id"                int8      NOT NULL,
    "gender"                 int2,
    "dob"                    date,
    "nationality"            varchar(45) COLLATE "pg_catalog"."default",
    "permanent_address"      varchar(255) COLLATE "pg_catalog"."default",
    "id_card_number"         varchar(45) COLLATE "pg_catalog"."default",
    "id_card_issuance_date"  date,
    "id_card_issuance_where" varchar(255) COLLATE "pg_catalog"."default",
    "tax_code"               varchar(45) COLLATE "pg_catalog"."default",
    "note"                   text COLLATE "pg_catalog"."default",
    "bank_name"              varchar(255) COLLATE "pg_catalog"."default",
    "bank_account_number"    varchar(20) COLLATE "pg_catalog"."default",
    "bank_account_name"      varchar(100) COLLATE "pg_catalog"."default",
    "bank_branch"            varchar(255) COLLATE "pg_catalog"."default",
    "created_at"             timestamp(6),
    "updated_at"             timestamp(6),
    "deleted_at"             timestamp(6)
)
;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS "users";
CREATE TABLE "users"
(
    "id"           bigserial                                   NOT NULL,
    "username"     varchar(50) COLLATE "pg_catalog"."default"  NOT NULL,
    "email"        varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
    "staff_code"   varchar(20) COLLATE "pg_catalog"."default"  NOT NULL,
    "phone_number" varchar(45) COLLATE "pg_catalog"."default",
    "password"     varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
    "type"         varchar(45) COLLATE "pg_catalog"."default"  NOT NULL,
    "first_name"   varchar(45) COLLATE "pg_catalog"."default"  NOT NULL,
    "last_name"    varchar(45) COLLATE "pg_catalog"."default"  NOT NULL,
    "is_active"    boolean DEFAULT true,
    "created_at"   timestamp(6),
    "updated_at"   timestamp(6),
    "deleted_at"   timestamp(6)
)
;

-- ----------------------------
-- Table structure for users_roles
-- ----------------------------
DROP TABLE IF EXISTS "users_roles";
CREATE TABLE "users_roles"
(
    "user_id" int8 NOT NULL,
    "role_id" int8 NOT NULL
)
;

-- ----------------------------
-- Indexes structure for table setting_themes
-- ----------------------------
CREATE INDEX "setting_themes_user_id_idx" ON "setting_themes" USING
    btree (
           "user_id" "pg_catalog"."int8_ops" ASC NULLS
           LAST
    );

-- ----------------------------
-- Primary Key structure for table setting_themes
-- ----------------------------
ALTER TABLE "setting_themes"
    ADD CONSTRAINT "setting_themes_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table activity_logs
-- ----------------------------
CREATE INDEX "activity_logs_user_id_idx" ON "activity_logs" USING
    btree (
           "user_id" "pg_catalog"."int8_ops" ASC NULLS
           LAST
    );

-- ----------------------------
-- Primary Key structure for table activity_logs
-- ----------------------------
ALTER TABLE "activity_logs"
    ADD CONSTRAINT "activity_logs_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table contract_types
-- ----------------------------
CREATE UNIQUE INDEX "name_vi_unique" ON "contract_types" USING
    btree (
           "name_vi" COLLATE "pg_catalog"."default"
           "pg_catalog"."text_ops" ASC NULLS LAST
    );
CREATE UNIQUE INDEX "name_en_unique" ON "contract_types" USING
    btree (
           "name_en" COLLATE "pg_catalog"."default"
           "pg_catalog"."text_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Primary Key structure for table contract_types
-- ----------------------------
ALTER TABLE "contract_types"
    ADD CONSTRAINT "pk_contract_types" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table contracts
-- ----------------------------
CREATE INDEX "contracts_contract_type_id_idx" ON "contracts" USING
    btree (
           "contract_type_id" "pg_catalog"."int8_ops" ASC
           NULLS LAST
    );
CREATE INDEX "contracts_creator_id_idx" ON "contracts" USING
    btree (
           "creator_id" "pg_catalog"."int8_ops" ASC NULLS LAST
    );
CREATE INDEX "contracts_gen_job_title_id_idx" ON "contracts" USING
    btree (
           "gen_job_title_id" "pg_catalog"."int8_ops" ASC
           NULLS LAST
    );
CREATE INDEX "contracts_gen_officer_level_id_idx" ON "contracts" USING
    btree (
           "gen_officer_level_id"
           "pg_catalog"."int8_ops" ASC NULLS LAST
    );
CREATE INDEX "contracts_gen_work_location_id_idx" ON "contracts" USING
    btree (
           "gen_work_location_id"
           "pg_catalog"."int8_ops" ASC NULLS LAST
    );
CREATE UNIQUE INDEX "contracts_user_id_unique" ON "contracts" USING
    btree (
           "user_id" "pg_catalog"."int8_ops" ASC NULLS
           LAST
    );

-- ----------------------------
-- Primary Key structure for table contracts
-- ----------------------------
ALTER TABLE "contracts"
    ADD CONSTRAINT "pk_contracts" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table gen_departments
-- ----------------------------
ALTER TABLE "gen_departments"
    ADD CONSTRAINT "gen_departments_pkey" PRIMARY KEY ("id");

CREATE UNIQUE INDEX "gen_departments_name_vi_unique" ON "gen_departments" USING
    btree (
           "name_vi"
           COLLATE "pg_catalog"."default"
           "pg_catalog"."text_ops" ASC NULLS
           LAST
    );
CREATE UNIQUE INDEX "gen_departments_name_en_unique" ON "gen_departments" USING
    btree (
           "name_en"
           COLLATE "pg_catalog"."default"
           "pg_catalog"."text_ops" ASC NULLS
           LAST
    );

-- ----------------------------
-- Primary Key structure for table gen_job_titles
-- ----------------------------
ALTER TABLE "gen_job_titles"
    ADD CONSTRAINT "pk_gen_job_titles" PRIMARY KEY ("id");

CREATE UNIQUE INDEX "gen_job_titles_name_vi_unique" ON "gen_departments" USING
    btree (
           "name_vi"
           COLLATE "pg_catalog"."default"
           "pg_catalog"."text_ops" ASC NULLS
           LAST
    );
CREATE UNIQUE INDEX "gen_job_titles_name_en_unique" ON "gen_departments" USING
    btree (
           "name_en"
           COLLATE "pg_catalog"."default"
           "pg_catalog"."text_ops" ASC NULLS
           LAST
    );

-- ----------------------------
-- Primary Key structure for table gen_officer_levels
-- ----------------------------
ALTER TABLE "gen_officer_levels"
    ADD CONSTRAINT "pk_gen_officer_levels" PRIMARY KEY ("id");

CREATE UNIQUE INDEX "gen_officer_levels_name_vi_unique" ON "gen_departments" USING
    btree (
           "name_vi"
           COLLATE "pg_catalog"."default"
           "pg_catalog"."text_ops" ASC
           NULLS LAST
    );
CREATE UNIQUE INDEX "gen_officer_levels_name_en_unique" ON "gen_departments" USING
    btree (
           "name_en"
           COLLATE "pg_catalog"."default"
           "pg_catalog"."text_ops" ASC
           NULLS LAST
    );

-- ----------------------------
-- Indexes structure for table gen_uploads
-- ----------------------------
CREATE UNIQUE INDEX "original_name_unique" ON "gen_uploads" USING
    btree (
           "original_name" COLLATE "pg_catalog"."default"
           "pg_catalog"."text_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Primary Key structure for table gen_uploads
-- ----------------------------
ALTER TABLE "gen_uploads"
    ADD CONSTRAINT "pk_gen_uploads" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table gen_work_locations
-- ----------------------------
ALTER TABLE "gen_work_locations"
    ADD CONSTRAINT "pk_gen_work_locations" PRIMARY KEY ("id");

CREATE UNIQUE INDEX "gen_work_locations_name_vi_unique" ON "gen_departments" USING
    btree (
           "name_vi"
           COLLATE "pg_catalog"."default"
           "pg_catalog"."text_ops" ASC
           NULLS LAST
    );
CREATE UNIQUE INDEX "gen_work_locations_name_en_unique" ON "gen_departments" USING
    btree (
           "name_en"
           COLLATE "pg_catalog"."default"
           "pg_catalog"."text_ops" ASC
           NULLS LAST
    );

-- ----------------------------
-- Primary Key structure for table permissions
-- ----------------------------
ALTER TABLE "permissions"
    ADD CONSTRAINT "pk_permissions" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table roles
-- ----------------------------
ALTER TABLE "roles"
    ADD CONSTRAINT "pk_roles" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table roles_permissions
-- ----------------------------
CREATE INDEX "roles_permissions_permission_id_idx" ON "roles_permissions" USING
    btree (
           "permission_id"
           "pg_catalog"."int8_ops" ASC NULLS
           LAST
    );
CREATE INDEX "roles_permissions_role_id_idx" ON "roles_permissions" USING
    btree (
           "role_id" "pg_catalog"."int8_ops" ASC
           NULLS LAST
    );

-- ----------------------------
-- Primary Key structure for table roles_permissions
-- ----------------------------
ALTER TABLE "roles_permissions"
    ADD CONSTRAINT "pk_roles_permissions" PRIMARY KEY ("role_id", "permission_id");

-- ----------------------------
-- Primary Key structure for table uploadables
-- ----------------------------
ALTER TABLE "uploadables"
    ADD CONSTRAINT "pk_uploadables" PRIMARY KEY ("gen_upload_id", "object_id");

-- ----------------------------
-- Indexes structure for table user_activities
-- ----------------------------
CREATE INDEX "user_activities_user_id_idx" ON "user_activities" USING
    btree (
           "user_id" "pg_catalog"."int8_ops" ASC NULLS
           LAST
    );

-- ----------------------------
-- Primary Key structure for table user_activities
-- ----------------------------
ALTER TABLE "user_activities"
    ADD CONSTRAINT "pk_user_activities" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table user_certificates
-- ----------------------------
CREATE INDEX "user_certificates_user_id_idx" ON "user_certificates" USING
    btree (
           "user_id" "pg_catalog"."int8_ops" ASC
           NULLS LAST
    );

-- ----------------------------
-- Primary Key structure for table user_certificates
-- ----------------------------
ALTER TABLE "user_certificates"
    ADD CONSTRAINT "pk_user_certificates" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table user_courses
-- ----------------------------
CREATE INDEX "user_courses_user_id_idx" ON "user_courses" USING
    btree (
           "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Primary Key structure for table user_courses
-- ----------------------------
ALTER TABLE "user_courses"
    ADD CONSTRAINT "pk_user_courses" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table user_profiles
-- ----------------------------
ALTER TABLE "user_profiles"
    ADD CONSTRAINT "pk_user_profiles" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table users
-- ----------------------------
CREATE UNIQUE INDEX "email_unique" ON "users" USING
    btree (
           "email" COLLATE "pg_catalog"."default"
           "pg_catalog"."text_ops" ASC NULLS LAST
    );
CREATE UNIQUE INDEX "username_unique" ON "users" USING
    btree (
           "username" COLLATE "pg_catalog"."default"
           "pg_catalog"."text_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Primary Key structure for table users
-- ----------------------------
ALTER TABLE "users"
    ADD CONSTRAINT "pk_users" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table users_roles
-- ----------------------------
CREATE INDEX "role_idx" ON "users_roles" USING
    btree (
           "role_id" "pg_catalog"."int8_ops" ASC NULLS LAST
    );

CREATE INDEX "user_idx" ON "users_roles" USING
    btree (
           "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Primary Key structure for table users_roles
-- ----------------------------
ALTER TABLE "users_roles"
    ADD CONSTRAINT "pk_users_roles" PRIMARY KEY ("user_id", "role_id");

-- ----------------------------
-- Foreign Keys structure for table contracts
-- ----------------------------
ALTER TABLE "contracts"
    ADD CONSTRAINT "contracts_contract_type_id" FOREIGN KEY ("contract_type_id") REFERENCES "contract_types" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "contracts"
    ADD CONSTRAINT "contracts_creator_id" FOREIGN KEY ("creator_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "contracts"
    ADD CONSTRAINT "contracts_gen_job_title_id" FOREIGN KEY ("gen_job_title_id") REFERENCES "gen_job_titles" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "contracts"
    ADD CONSTRAINT "contracts_gen_officer_level_id" FOREIGN KEY ("gen_officer_level_id") REFERENCES "gen_officer_levels" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "contracts"
    ADD CONSTRAINT "contracts_gen_work_location_id" FOREIGN KEY ("gen_work_location_id") REFERENCES "gen_work_locations" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "contracts"
    ADD CONSTRAINT "contracts_user_id" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table roles_permissions
-- ----------------------------
ALTER TABLE "roles_permissions"
    ADD CONSTRAINT "permission_fk" FOREIGN KEY ("permission_id") REFERENCES "permissions" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "roles_permissions"
    ADD CONSTRAINT "role_fk_p" FOREIGN KEY ("role_id") REFERENCES "roles" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table uploadables
-- ----------------------------
ALTER TABLE "uploadables"
    ADD CONSTRAINT "uploadables_gen_upload_id" FOREIGN KEY ("gen_upload_id") REFERENCES "gen_uploads" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table user_activities
-- ----------------------------
ALTER TABLE "user_activities"
    ADD CONSTRAINT "user_activities_user_id" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table user_certificates
-- ----------------------------
ALTER TABLE "user_certificates"
    ADD CONSTRAINT "user_certificates_user_id" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table user_courses
-- ----------------------------
ALTER TABLE "user_courses"
    ADD CONSTRAINT "user_courses_user_id" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table user_profiles
-- ----------------------------
ALTER TABLE "user_profiles"
    ADD CONSTRAINT "user_profiles_user_id" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table users_roles
-- ----------------------------
ALTER TABLE "users_roles"
    ADD CONSTRAINT "role_fk" FOREIGN KEY ("role_id") REFERENCES "roles" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "users_roles"
    ADD CONSTRAINT "user_fk" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table setting_themes
-- ----------------------------
ALTER TABLE "setting_themes"
    ADD CONSTRAINT "setting_themes_user_id" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Table structure for tags
-- ----------------------------
DROP TABLE IF EXISTS "tags";
CREATE TABLE "tags"
(
    "id"         bigserial                                   NOT NULL,
    "name"       varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
    "is_active"  boolean DEFAULT true,
    "created_at" timestamp(6),
    "updated_at" timestamp(6),
    "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Primary Key structure for table tags
-- ----------------------------
ALTER TABLE "tags"
    ADD CONSTRAINT "pk_tags" PRIMARY KEY ("id");

-- ----------------------------
-- Table structure for tagables
-- ----------------------------
DROP TABLE IF EXISTS "tagables";
CREATE TABLE "tagables"
(
    "tag_id"       int8 NOT NULL,
    "object_id"    int8 NOT NULL,
    "object_type"  varchar(45) COLLATE "pg_catalog"."default",
    "object_field" varchar(45) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Primary Key structure for table tagables
-- ----------------------------
ALTER TABLE "tagables"
    ADD CONSTRAINT "pk_tagables" PRIMARY KEY ("tag_id", "object_id");

COMMENT ON COLUMN "tagables"."object_id" is 'ID of reference object';
COMMENT ON COLUMN "tagables"."object_type" is 'table name of reference object';
COMMENT ON COLUMN "tagables"."object_field" is 'field name of reference object. Ex: logo, avatar, ...';

-- ----------------------------
-- Table structure for crm_leads - Has Many with tags
-- ----------------------------
DROP TABLE IF EXISTS "crm_leads";
CREATE TABLE "crm_leads"
(
    "id"         bigserial                                   NOT NULL,
    "name"       varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
    "describe"   text COLLATE "pg_catalog"."default",
    "is_active"  boolean DEFAULT true,
    "created_at" timestamp(6),
    "updated_at" timestamp(6),
    "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Primary Key structure for table crm_leads
-- ----------------------------
ALTER TABLE "crm_leads"
    ADD CONSTRAINT "pk_crm_leads" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table crm_leads
-- ----------------------------
CREATE UNIQUE INDEX "crm_leads_name_unique" ON "crm_leads" USING
    btree (
           "name" COLLATE "pg_catalog"."default"
           "pg_catalog"."text_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Table structure for crm_lead_items
-- ----------------------------
DROP TABLE IF EXISTS "crm_lead_items";
CREATE TABLE "crm_lead_items"
(
    "id"          bigserial                                   NOT NULL,
    "crm_lead_id" int8                                        NOT NULL,
    "name"        varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
    "color"       varchar(10) COLLATE "pg_catalog"."default",
    "describe"    text COLLATE "pg_catalog"."default",
    "is_active"   boolean DEFAULT true,
    "created_at"  timestamp(6),
    "updated_at"  timestamp(6),
    "deleted_at"  timestamp(6)
)
;

-- ----------------------------
-- Primary Key structure for table crm_lead_items
-- ----------------------------
ALTER TABLE "crm_lead_items"
    ADD CONSTRAINT "pk_crm_lead_items" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table crm_lead_items
-- ----------------------------
CREATE INDEX "crm_lead_items_crm_lead_id_idx" ON "crm_lead_items" USING
    btree (
           "crm_lead_id" "pg_catalog"."int8_ops" ASC
           NULLS LAST
    );

-- ----------------------------
-- Foreign Keys structure for table crm_lead_items
-- ----------------------------
ALTER TABLE "crm_lead_items"
    ADD CONSTRAINT "crm_lead_items_crm_lead_id" FOREIGN KEY ("crm_lead_id") REFERENCES "crm_leads" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Table structure for crm_companies - Has file logo, Has Many with tags
-- ----------------------------
DROP TABLE IF EXISTS "crm_companies";
CREATE TABLE "crm_companies"
(
    "id"                bigserial                                  NOT NULL,
    "tax_code"          varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
    "company_name_vi"   varchar(255) COLLATE "pg_catalog"."default",
    "company_name_en"   varchar(255) COLLATE "pg_catalog"."default",
    "company_ceo"       varchar(100) COLLATE "pg_catalog"."default",
    "abbreviation_name" varchar(255) COLLATE "pg_catalog"."default",
    "headquarter"       varchar(45) COLLATE "pg_catalog"."default",
    "main_tel"          varchar(20) COLLATE "pg_catalog"."default",
    "main_fax"          varchar(20) COLLATE "pg_catalog"."default",
    "main_email"        varchar(100) COLLATE "pg_catalog"."default",
    "operation_day"     date,
    "is_active"         boolean DEFAULT true,
    "created_at"        timestamp(6),
    "updated_at"        timestamp(6),
    "deleted_at"        timestamp(6)
)
;

-- ----------------------------
-- Primary Key structure for table crm_companies
-- ----------------------------
ALTER TABLE "crm_companies"
    ADD CONSTRAINT "pk_crm_companies" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table crm_companies
-- ----------------------------
CREATE UNIQUE INDEX "crm_companies_tax_code_unique" ON "crm_companies" USING
    btree (
           "tax_code" COLLATE "pg_catalog"."default"
           "pg_catalog"."text_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Table structure for crm_contacts - Has file avatar, Has Many with tags
-- ----------------------------
DROP TABLE IF EXISTS "crm_contacts";
CREATE TABLE "crm_contacts"
(
    "id"             bigserial                                   NOT NULL,
    "crm_company_id" int8                                        NOT NULL,
    "email"          varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
    "tel"            varchar(20) COLLATE "pg_catalog"."default",
    "first_name"     varchar(50) COLLATE "pg_catalog"."default",
    "last_name"      varchar(50) COLLATE "pg_catalog"."default",
    "english_name"   varchar(50) COLLATE "pg_catalog"."default",
    "designation"    varchar(100) COLLATE "pg_catalog"."default",
    "is_active"      boolean DEFAULT true,
    "created_at"     timestamp(6),
    "updated_at"     timestamp(6),
    "deleted_at"     timestamp(6)
)
;

COMMENT
    ON COLUMN "crm_contacts"."designation" is 'Chức vụ được chỉ định';

-- ----------------------------
-- Primary Key structure for table crm_contacts
-- ----------------------------
ALTER TABLE "crm_contacts"
    ADD CONSTRAINT "pk_crm_contacts" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table documents
-- ----------------------------
ALTER TABLE "crm_contacts"
    ADD CONSTRAINT "crm_contacts_crm_company_id" FOREIGN KEY ("crm_company_id") REFERENCES "crm_companies" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Table structure for crm_companies_crm_leads
-- ----------------------------
DROP TABLE IF EXISTS "crm_companies_crm_leads";
CREATE TABLE "crm_companies_crm_leads"
(
    "crm_company_id"   int8 NOT NULL,
    "crm_lead_id"      int8 NOT NULL,
    "crm_lead_item_id" int8 NOT NULL
)
;
-- ----------------------------
-- Indexes structure for table crm_companies_crm_leads
-- ----------------------------
CREATE INDEX "crm_company_idx" ON "crm_companies_crm_leads" USING
    btree (
           "crm_company_id" "pg_catalog"."int8_ops" ASC NULLS LAST
    );

CREATE INDEX "crm_lead_idx" ON "crm_companies_crm_leads" USING
    btree (
           "crm_lead_id" "pg_catalog"."int8_ops" ASC NULLS LAST
    );

CREATE INDEX "crm_lead_item_idx" ON "crm_companies_crm_leads" USING
    btree (
           "crm_lead_item_id" "pg_catalog"."int8_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Primary Key structure for table crm_companies_crm_leads
-- ----------------------------
ALTER TABLE "crm_companies_crm_leads"
    ADD CONSTRAINT "pk_crm_companies_crm_leads" PRIMARY KEY ("crm_company_id", "crm_lead_id", "crm_lead_item_id");

-- ----------------------------
-- Foreign Keys structure for table crm_companies_crm_leads
-- ----------------------------
ALTER TABLE "crm_companies_crm_leads"
    ADD CONSTRAINT "crm_company_fk" FOREIGN KEY ("crm_company_id") REFERENCES "crm_companies" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "crm_companies_crm_leads"
    ADD CONSTRAINT "crm_lead_fk" FOREIGN KEY ("crm_lead_id") REFERENCES "crm_leads" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "crm_companies_crm_leads"
    ADD CONSTRAINT "crm_lead_item_id_fk" FOREIGN KEY ("crm_lead_item_id") REFERENCES "crm_lead_items" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Table structure for crm_contacts_crm_leads
-- ----------------------------
DROP TABLE IF EXISTS "crm_contacts_crm_leads";
CREATE TABLE "crm_contacts_crm_leads"
(
    "crm_contact_id"   int8 NOT NULL,
    "crm_lead_id"      int8 NOT NULL,
    "crm_lead_item_id" int8 NOT NULL
)
;
-- ----------------------------
-- Indexes structure for table crm_contacts_crm_leads
-- ----------------------------
CREATE INDEX "crm_contact_idx" ON "crm_contacts_crm_leads" USING
    btree (
           "crm_contact_id" "pg_catalog"."int8_ops" ASC NULLS LAST
    );

CREATE INDEX "contacts_crm_lead_idx" ON "crm_contacts_crm_leads" USING
    btree (
           "crm_lead_id" "pg_catalog"."int8_ops" ASC NULLS LAST
    );

CREATE INDEX "contacts_crm_lead_item_idx" ON "crm_contacts_crm_leads" USING
    btree (
           "crm_lead_item_id" "pg_catalog"."int8_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Primary Key structure for table crm_contacts_crm_leads
-- ----------------------------
ALTER TABLE "crm_contacts_crm_leads"
    ADD CONSTRAINT "pk_crm_contacts_crm_leads" PRIMARY KEY ("crm_contact_id", "crm_lead_id", "crm_lead_item_id");

-- ----------------------------
-- Foreign Keys structure for table crm_contacts_crm_leads
-- ----------------------------
ALTER TABLE "crm_contacts_crm_leads"
    ADD CONSTRAINT "contacts_crm_contact_fk" FOREIGN KEY ("crm_contact_id") REFERENCES "crm_contacts" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "crm_contacts_crm_leads"
    ADD CONSTRAINT "contacts_crm_lead_fk" FOREIGN KEY ("crm_lead_id") REFERENCES "crm_leads" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "crm_contacts_crm_leads"
    ADD CONSTRAINT "contacts_crm_lead_item_id_fk" FOREIGN KEY ("crm_lead_item_id") REFERENCES "crm_lead_items" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ----------------------------
-- Table structure for document_groups
-- ----------------------------
DROP TABLE IF EXISTS "document_groups";
CREATE TABLE "document_groups"
(
    "id"         bigserial                                   NOT NULL,
    "parent_id"  int8,
    "name_vi"    varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
    "name_en"    varchar(100) COLLATE "pg_catalog"."default",
    "is_active"  boolean DEFAULT true,
    "created_at" timestamp(6),
    "updated_at" timestamp(6),
    "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Primary Key structure for table document_groups
-- ----------------------------
ALTER TABLE "document_groups"
    ADD CONSTRAINT "pk_document_groups" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table document_groups
-- ----------------------------
CREATE UNIQUE INDEX "document_groups_name_vi_unique" ON "document_groups" USING
    btree (
           "name_vi" COLLATE "pg_catalog"."default"
           "pg_catalog"."text_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Table structure for documents - a lot of file attachment
-- ----------------------------
DROP TABLE IF EXISTS "documents";
CREATE TABLE "documents"
(
    "id"                bigserial                                   NOT NULL,
    "document_group_id" int8                                        NOT NULL,
    "name_vi"           varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
    "name_en"           varchar(255) COLLATE "pg_catalog"."default",
    "describe"          text COLLATE "pg_catalog"."default",
    "is_active"         boolean DEFAULT true,
    "created_at"        timestamp(6),
    "updated_at"        timestamp(6),
    "deleted_at"        timestamp(6)
)
;

-- ----------------------------
-- Primary Key structure for table documents
-- ----------------------------
ALTER TABLE "documents"
    ADD CONSTRAINT "pk_documents" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table documents
-- ----------------------------
CREATE UNIQUE INDEX "documents_name_vi_unique" ON "documents" USING
    btree (
           "name_vi" COLLATE "pg_catalog"."default"
           "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX "documents_document_group_id_idx" ON "documents" USING
    btree (
           "document_group_id" "pg_catalog"."int8_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Table structure for material_groups
-- ----------------------------
DROP TABLE IF EXISTS "material_groups";
CREATE TABLE "material_groups"
(
    "id"         bigserial                                   NOT NULL,
    "name_vi"    varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
    "name_en"    varchar(100) COLLATE "pg_catalog"."default",
    "type"       varchar(45) COLLATE "pg_catalog"."default"  NOT NULL,
    "is_active"  boolean DEFAULT true,
    "created_at" timestamp(6),
    "updated_at" timestamp(6),
    "deleted_at" timestamp(6)
)
;

COMMENT
    ON COLUMN "material_groups"."type" is 'materials, tools\nNhóm nguyên vật liệu, Nhóm công cụ dụng cụ';

-- ----------------------------
-- Primary Key structure for table material_groups
-- ----------------------------
ALTER TABLE "material_groups"
    ADD CONSTRAINT "pk_material_groups" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table material_groups
-- ----------------------------
CREATE UNIQUE INDEX "material_groups_name_vi_unique" ON "material_groups" USING
    btree (
           "name_vi" COLLATE "pg_catalog"."default"
           "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX "material_groups_type_idx" ON "material_groups" USING
    btree (
           "type" "pg_catalog"."varchar_pattern_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Table structure for gen_units
-- ----------------------------
DROP TABLE IF EXISTS "gen_units";
CREATE TABLE "gen_units"
(
    "id"         bigserial                                   NOT NULL,
    "name_vi"    varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
    "name_en"    varchar(100) COLLATE "pg_catalog"."default",
    "is_active"  boolean DEFAULT true,
    "created_at" timestamp(6),
    "updated_at" timestamp(6),
    "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Primary Key structure for table gen_units
-- ----------------------------
ALTER TABLE "gen_units"
    ADD CONSTRAINT "pk_gen_units" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table gen_units
-- ----------------------------
CREATE UNIQUE INDEX "gen_units_name_vi_unique" ON "gen_units" USING
    btree (
           "name_vi" COLLATE "pg_catalog"."default"
           "pg_catalog"."text_ops" ASC NULLS LAST
    );


-- ----------------------------
-- Table structure for materials - Has file image
-- ----------------------------
DROP TABLE IF EXISTS "materials";
CREATE TABLE "materials"
(
    "id"                bigserial                                   NOT NULL,
    "gen_unit_id"       int8                                        NOT NULL,
    "material_group_id" int8                                        NOT NULL,
    "name_vi"           varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
    "name_en"           varchar(100) COLLATE "pg_catalog"."default",
    "name_science"      varchar(255) COLLATE "pg_catalog"."default",
    "name_other"        text COLLATE "pg_catalog"."default",
    "inventory_min"     int8                                        NOT NULL,
    "inventory_max"     int8                                        NOT NULL,
    "describe"          text COLLATE "pg_catalog"."default",
    "belong_to"         varchar(45) COLLATE "pg_catalog"."default"  NOT NULL,
    "is_active"         boolean DEFAULT true,
    "created_at"        timestamp(6),
    "updated_at"        timestamp(6),
    "deleted_at"        timestamp(6)
)
;

COMMENT
    ON COLUMN "materials"."belong_to" is 'Thuộc về machine, manufacture\nMáy móc, Sản xuất';

-- ----------------------------
-- Primary Key structure for table materials
-- ----------------------------
ALTER TABLE "materials"
    ADD CONSTRAINT "pk_materials" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table materials
-- ----------------------------
CREATE UNIQUE INDEX "materials_name_vi_unique" ON "materials" USING
    btree (
           "name_vi" COLLATE "pg_catalog"."default"
           "pg_catalog"."text_ops" ASC NULLS LAST
    );

CREATE INDEX "materials_gen_unit_id_idx" ON "materials" USING
    btree (
           "gen_unit_id" "pg_catalog"."int8_ops" ASC NULLS LAST
    );

CREATE INDEX "materials_material_group_id_idx" ON "materials" USING
    btree (
           "material_group_id" "pg_catalog"."int8_ops" ASC NULLS LAST
    );

CREATE INDEX "materials_belong_to_idx" ON "materials" USING
    btree (
           "belong_to" "pg_catalog"."varchar_pattern_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Foreign Keys structure for table materials
-- ----------------------------
ALTER TABLE "materials"
    ADD CONSTRAINT "materials_gen_unit_id" FOREIGN KEY ("gen_unit_id") REFERENCES "gen_units" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "materials"
    ADD CONSTRAINT "materials_material_group_id" FOREIGN KEY ("material_group_id") REFERENCES "material_groups" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ----------------------------
-- Table structure for suppliers - Has file logo, has Many with tags
-- ----------------------------
DROP TABLE IF EXISTS "suppliers";
CREATE TABLE "suppliers"
(
    "id"                bigserial                                  NOT NULL,
    "tax_code"          varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
    "company_name_vi"   varchar(255) COLLATE "pg_catalog"."default",
    "company_name_en"   varchar(255) COLLATE "pg_catalog"."default",
    "company_ceo"       varchar(100) COLLATE "pg_catalog"."default",
    "abbreviation_name" varchar(255) COLLATE "pg_catalog"."default",
    "headquarter"       varchar(45) COLLATE "pg_catalog"."default",
    "main_tel"          varchar(20) COLLATE "pg_catalog"."default",
    "main_fax"          varchar(20) COLLATE "pg_catalog"."default",
    "main_email"        varchar(100) COLLATE "pg_catalog"."default",
    "operation_day"     date,
    "is_active"         boolean DEFAULT true,
    "created_at"        timestamp(6),
    "updated_at"        timestamp(6),
    "deleted_at"        timestamp(6)
)
;

-- ----------------------------
-- Primary Key structure for table suppliers
-- ----------------------------
ALTER TABLE "suppliers"
    ADD CONSTRAINT "pk_suppliers" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table suppliers
-- ----------------------------
CREATE UNIQUE INDEX "suppliers_tax_code_unique" ON "suppliers" USING btree (
                                                                            "tax_code" COLLATE "pg_catalog"."default"
                                                                            "pg_catalog"."text_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Table structure for supplier_contacts - Has file avatar
-- ----------------------------
DROP TABLE IF EXISTS "supplier_contacts";
CREATE TABLE "supplier_contacts"
(
    "id"           bigserial                                   NOT NULL,
    "supplier_id"  int8                                        NOT NULL,
    "email"        varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
    "tel"          varchar(20) COLLATE "pg_catalog"."default",
    "first_name"   varchar(50) COLLATE "pg_catalog"."default",
    "last_name"    varchar(50) COLLATE "pg_catalog"."default",
    "english_name" varchar(50) COLLATE "pg_catalog"."default",
    "designation"  varchar(100) COLLATE "pg_catalog"."default",
    "is_active"    boolean DEFAULT true,
    "created_at"   timestamp(6),
    "updated_at"   timestamp(6),
    "deleted_at"   timestamp(6)
)
;

COMMENT
    ON COLUMN "supplier_contacts"."designation" is 'Chức vụ được chỉ định';

-- ----------------------------
-- Primary Key structure for table supplier_contacts
-- ----------------------------
ALTER TABLE "supplier_contacts"
    ADD CONSTRAINT "pk_supplier_contacts" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table documents
-- ----------------------------
ALTER TABLE "supplier_contacts"
    ADD CONSTRAINT "supplier_contacts_crm_company_id" FOREIGN KEY ("supplier_id") REFERENCES "suppliers" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;