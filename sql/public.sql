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
CREATE TABLE "setting_themes" (
  "id" bigserial NOT NULL,
  "user_id" int8 NOT NULL,
  "layout" varchar(20) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'vertical',
  "color_scheme" varchar(20) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'light',
  "topbar_color" varchar(20) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'light',
  "sidebar_color" varchar(20) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'light',
  "sidebar_img" varchar(20) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'none',
  "preloader" varchar(20) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'enable',
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "deleted_at" timestamp(6)
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
CREATE TABLE "activity_logs" (
  "id" bigserial NOT NULL,
  "user_id" int8,
  "ip" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "user_agent" text COLLATE "pg_catalog"."default",
  "request" text COLLATE "pg_catalog"."default",
  "response" text COLLATE "pg_catalog"."default",
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for contract_types
-- ----------------------------
DROP TABLE IF EXISTS "contract_types";
CREATE TABLE "contract_types" (
  "id" bigserial NOT NULL,
  "name_vi" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "name_en" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "is_determine_deadline" boolean NOT NULL DEFAULT false,
  "is_active" boolean NOT NULL DEFAULT true,
  "describe" text COLLATE "pg_catalog"."default",
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for contracts
-- ----------------------------
DROP TABLE IF EXISTS "contracts";
CREATE TABLE "contracts" (
  "id" bigserial NOT NULL,
  "user_id" int8 NOT NULL,
  "creator_id" int8 NOT NULL,
  "contract_type_id" int8 NOT NULL,
  "gen_work_location_id" int8 NOT NULL,
  "gen_officer_level_id" int8 NOT NULL,
  "gen_department_id" int8 NOT NULL,
  "gen_job_title_id" int8 NOT NULL,
  "contract_code" varchar(45) COLLATE "pg_catalog"."default" NOT NULL,
  "duration" int8,
  "start_date" date,
  "end_date" date,
  "status" varchar(45) COLLATE "pg_catalog"."default" NOT NULL,
  "note" text COLLATE "pg_catalog"."default",
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "deleted_at" timestamp(6)
)
;

COMMENT ON COLUMN "contracts"."status" is 'Draft, To confirm, To review, Approved, Running, Pending, Expired, Liquidated, Rejected\nDự thảo, để xác nhận, xem xét, phê duyệt, chạy, chờ xử lý, hết hạn, bị thanh lý, bị từ chối';

-- ----------------------------
-- Table structure for gen_departments
-- ----------------------------
DROP TABLE IF EXISTS "gen_departments";
CREATE TABLE "gen_departments" (
  "id" bigserial NOT NULL,
  "name_vi" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "name_en" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "describe" text COLLATE "pg_catalog"."default",
  "is_active" boolean NOT NULL DEFAULT true,
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for gen_job_titles
-- ----------------------------
DROP TABLE IF EXISTS "gen_job_titles";
CREATE TABLE "gen_job_titles" (
  "id" bigserial NOT NULL,
  "name_vi" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "name_en" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "salary" int8,
  "describe" text COLLATE "pg_catalog"."default",
  "is_active" boolean NOT NULL DEFAULT true,
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for gen_officer_levels
-- ----------------------------
DROP TABLE IF EXISTS "gen_officer_levels";
CREATE TABLE "gen_officer_levels" (
  "id" bigserial NOT NULL,
  "name_vi" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "name_en" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "describe" text COLLATE "pg_catalog"."default",
  "is_active" boolean NOT NULL DEFAULT true,
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for gen_uploads
-- ----------------------------
DROP TABLE IF EXISTS "gen_uploads";
CREATE TABLE "gen_uploads" (
  "id" bigserial NOT NULL,
  "original_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "file_name" varchar(45) COLLATE "pg_catalog"."default" NOT NULL,
  "extension" varchar(10) COLLATE "pg_catalog"."default" NOT NULL,
  "content_type" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "data" bytea NOT NULL,
  "size" float4 NOT NULL,
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for gen_work_locations
-- ----------------------------
DROP TABLE IF EXISTS "gen_work_locations";
CREATE TABLE "gen_work_locations" (
  "id" bigserial NOT NULL,
  "name_vi" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "name_en" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "describe" text COLLATE "pg_catalog"."default",
  "is_active" boolean NOT NULL DEFAULT true,
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS "permissions";
CREATE TABLE "permissions" (
  "id" bigserial NOT NULL,
  "group" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "key" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "is_active" boolean NOT NULL DEFAULT true,
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS "roles";
CREATE TABLE "roles" (
  "id" bigserial NOT NULL,
  "name_vi" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "name_en" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "describe" text COLLATE "pg_catalog"."default",
  "is_default" boolean NOT NULL DEFAULT false,
  "is_active" boolean NOT NULL DEFAULT true,
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS "roles_permissions";
CREATE TABLE "roles_permissions" (
  "role_id" int8 NOT NULL,
  "permission_id" int8 NOT NULL
)
;

-- ----------------------------
-- Table structure for uploadables
-- ----------------------------
DROP TABLE IF EXISTS "uploadables";
CREATE TABLE "uploadables" (
  "gen_upload_id" int8 NOT NULL,
  "object_id" int8 NOT NULL,
  "object_type" varchar(45) COLLATE "pg_catalog"."default",
  "object_filed" varchar(45) COLLATE "pg_catalog"."default",
  "describe" text COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for user_activities
-- ----------------------------
DROP TABLE IF EXISTS "user_activities";
CREATE TABLE "user_activities" (
  "id" bigserial NOT NULL,
  "user_id" int8 NOT NULL,
  "organization" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "participating_position" varchar(255) COLLATE "pg_catalog"."default",
  "is_current_active" boolean DEFAULT false,
  "start_date" varchar(45) COLLATE "pg_catalog"."default",
  "end_date" varchar(45) COLLATE "pg_catalog"."default",
  "describe" text COLLATE "pg_catalog"."default",
  "link" varchar(255) COLLATE "pg_catalog"."default",
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for user_certificates
-- ----------------------------
DROP TABLE IF EXISTS "user_certificates";
CREATE TABLE "user_certificates" (
  "id" bigserial NOT NULL,
  "user_id" int8 NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "organization" varchar(255) COLLATE "pg_catalog"."default",
  "has_no_expiration_date" boolean DEFAULT true,
  "start_date" varchar(45) COLLATE "pg_catalog"."default",
  "end_date" varchar(45) COLLATE "pg_catalog"."default",
  "link" varchar(255) COLLATE "pg_catalog"."default",
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for user_courses
-- ----------------------------
DROP TABLE IF EXISTS "user_courses";
CREATE TABLE "user_courses" (
  "id" bigserial NOT NULL,
  "user_id" int8 NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "organization" varchar(255) COLLATE "pg_catalog"."default",
  "start_date" varchar(45) COLLATE "pg_catalog"."default",
  "end_date" varchar(45) COLLATE "pg_catalog"."default",
  "describe" text COLLATE "pg_catalog"."default",
  "link" varchar(255) COLLATE "pg_catalog"."default",
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for user_profiles
-- ----------------------------
DROP TABLE IF EXISTS "user_profiles";
CREATE TABLE "user_profiles" (
  "id" bigserial NOT NULL,
  "user_id" int8 NOT NULL,
  "gender" int2,
  "dob" date,
  "nationality" varchar(45) COLLATE "pg_catalog"."default",
  "permanent_address" varchar(255) COLLATE "pg_catalog"."default",
  "id_card_number" varchar(45) COLLATE "pg_catalog"."default",
  "id_card_issuance_date" date,
  "id_card_issuance_where" varchar(255) COLLATE "pg_catalog"."default",
  "tax_code" varchar(45) COLLATE "pg_catalog"."default",
  "note" text COLLATE "pg_catalog"."default",
  "bank_name" varchar(255) COLLATE "pg_catalog"."default",
  "bank_account_number" varchar(20) COLLATE "pg_catalog"."default",
  "bank_account_name" varchar(100) COLLATE "pg_catalog"."default",
  "bank_branch" varchar(255) COLLATE "pg_catalog"."default",
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS "users";
CREATE TABLE "users" (
  "id" bigserial NOT NULL,
  "username" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "email" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "staff_code" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "phone_number" varchar(45) COLLATE "pg_catalog"."default",
  "password" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "type" varchar(45) COLLATE "pg_catalog"."default" NOT NULL,
  "first_name" varchar(45) COLLATE "pg_catalog"."default" NOT NULL,
  "last_name" varchar(45) COLLATE "pg_catalog"."default" NOT NULL,
  "is_active" boolean DEFAULT true,
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for users_roles
-- ----------------------------
DROP TABLE IF EXISTS "users_roles";
CREATE TABLE "users_roles" (
  "user_id" int8 NOT NULL,
  "role_id" int8 NOT NULL
)
;

-- ----------------------------
-- Indexes structure for table setting_themes
-- ----------------------------
CREATE INDEX "setting_themes_user_id_idx" ON "setting_themes" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table setting_themes
-- ----------------------------
ALTER TABLE "setting_themes" ADD CONSTRAINT "setting_themes_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table activity_logs
-- ----------------------------
CREATE INDEX "activity_logs_user_id_idx" ON "activity_logs" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table activity_logs
-- ----------------------------
ALTER TABLE "activity_logs" ADD CONSTRAINT "activity_logs_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table contract_types
-- ----------------------------
CREATE UNIQUE INDEX "name_vi_unique" ON "contract_types" USING btree (
  "name_vi" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE UNIQUE INDEX "name_en_unique" ON "contract_types" USING btree (
  "name_en" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table contract_types
-- ----------------------------
ALTER TABLE "contract_types" ADD CONSTRAINT "pk_contract_types" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table contracts
-- ----------------------------
CREATE INDEX "contracts_contract_type_id_idx" ON "contracts" USING btree (
  "contract_type_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "contracts_creator_id_idx" ON "contracts" USING btree (
  "creator_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "contracts_gen_job_title_id_idx" ON "contracts" USING btree (
  "gen_job_title_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "contracts_gen_officer_level_id_idx" ON "contracts" USING btree (
  "gen_officer_level_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "contracts_gen_work_location_id_idx" ON "contracts" USING btree (
  "gen_work_location_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE UNIQUE INDEX "contracts_user_id_unique" ON "contracts" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table contracts
-- ----------------------------
ALTER TABLE "contracts" ADD CONSTRAINT "pk_contracts" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table gen_departments
-- ----------------------------
ALTER TABLE "gen_departments" ADD CONSTRAINT "gen_departments_pkey" PRIMARY KEY ("id");

CREATE UNIQUE INDEX "gen_departments_name_vi_unique" ON "gen_departments" USING btree (
  "name_vi" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE UNIQUE INDEX "gen_departments_name_en_unique" ON "gen_departments" USING btree (
  "name_en" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table gen_job_titles
-- ----------------------------
ALTER TABLE "gen_job_titles" ADD CONSTRAINT "pk_gen_job_titles" PRIMARY KEY ("id");

CREATE UNIQUE INDEX "gen_job_titles_name_vi_unique" ON "gen_departments" USING btree (
  "name_vi" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE UNIQUE INDEX "gen_job_titles_name_en_unique" ON "gen_departments" USING btree (
  "name_en" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table gen_officer_levels
-- ----------------------------
ALTER TABLE "gen_officer_levels" ADD CONSTRAINT "pk_gen_officer_levels" PRIMARY KEY ("id");

CREATE UNIQUE INDEX "gen_officer_levels_name_vi_unique" ON "gen_departments" USING btree (
  "name_vi" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE UNIQUE INDEX "gen_officer_levels_name_en_unique" ON "gen_departments" USING btree (
  "name_en" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Indexes structure for table gen_uploads
-- ----------------------------
CREATE UNIQUE INDEX "original_name_unique" ON "gen_uploads" USING btree (
  "original_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table gen_uploads
-- ----------------------------
ALTER TABLE "gen_uploads" ADD CONSTRAINT "pk_gen_uploads" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table gen_work_locations
-- ----------------------------
ALTER TABLE "gen_work_locations" ADD CONSTRAINT "pk_gen_work_locations" PRIMARY KEY ("id");

CREATE UNIQUE INDEX "gen_work_locations_name_vi_unique" ON "gen_departments" USING btree (
  "name_vi" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE UNIQUE INDEX "gen_work_locations_name_en_unique" ON "gen_departments" USING btree (
  "name_en" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table permissions
-- ----------------------------
ALTER TABLE "permissions" ADD CONSTRAINT "pk_permissions" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table roles
-- ----------------------------
ALTER TABLE "roles" ADD CONSTRAINT "pk_roles" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table roles_permissions
-- ----------------------------
CREATE INDEX "roles_permissions_permission_id_idx" ON "roles_permissions" USING btree (
  "permission_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "roles_permissions_role_id_idx" ON "roles_permissions" USING btree (
  "role_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table roles_permissions
-- ----------------------------
ALTER TABLE "roles_permissions" ADD CONSTRAINT "pk_roles_permissions" PRIMARY KEY ("role_id", "permission_id");

-- ----------------------------
-- Primary Key structure for table uploadables
-- ----------------------------
ALTER TABLE "uploadables" ADD CONSTRAINT "pk_uploadables" PRIMARY KEY ("gen_upload_id", "object_id");

-- ----------------------------
-- Indexes structure for table user_activities
-- ----------------------------
CREATE INDEX "user_activities_user_id_idx" ON "user_activities" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table user_activities
-- ----------------------------
ALTER TABLE "user_activities" ADD CONSTRAINT "pk_user_activities" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table user_certificates
-- ----------------------------
CREATE INDEX "user_certificates_user_id_idx" ON "user_certificates" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table user_certificates
-- ----------------------------
ALTER TABLE "user_certificates" ADD CONSTRAINT "pk_user_certificates" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table user_courses
-- ----------------------------
CREATE INDEX "user_courses_user_id_idx" ON "user_courses" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table user_courses
-- ----------------------------
ALTER TABLE "user_courses" ADD CONSTRAINT "pk_user_courses" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table user_profiles
-- ----------------------------
ALTER TABLE "user_profiles" ADD CONSTRAINT "pk_user_profiles" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table users
-- ----------------------------
CREATE UNIQUE INDEX "email_unique" ON "users" USING btree (
  "email" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE UNIQUE INDEX "username_unique" ON "users" USING btree (
  "username" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table users
-- ----------------------------
ALTER TABLE "users" ADD CONSTRAINT "pk_users" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table users_roles
-- ----------------------------
CREATE INDEX "role_fk" ON "users_roles" USING btree (
  "role_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table users_roles
-- ----------------------------
ALTER TABLE "users_roles" ADD CONSTRAINT "pk_users_roles" PRIMARY KEY ("user_id", "role_id");

-- ----------------------------
-- Foreign Keys structure for table contracts
-- ----------------------------
ALTER TABLE "contracts" ADD CONSTRAINT "contracts_contract_type_id" FOREIGN KEY ("contract_type_id") REFERENCES "contract_types" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "contracts" ADD CONSTRAINT "contracts_creator_id" FOREIGN KEY ("creator_id") REFERENCES "users" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "contracts" ADD CONSTRAINT "contracts_gen_job_title_id" FOREIGN KEY ("gen_job_title_id") REFERENCES "gen_job_titles" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "contracts" ADD CONSTRAINT "contracts_gen_officer_level_id" FOREIGN KEY ("gen_officer_level_id") REFERENCES "gen_officer_levels" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "contracts" ADD CONSTRAINT "contracts_gen_work_location_id" FOREIGN KEY ("gen_work_location_id") REFERENCES "gen_work_locations" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "contracts" ADD CONSTRAINT "contracts_user_id" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table roles_permissions
-- ----------------------------
ALTER TABLE "roles_permissions" ADD CONSTRAINT "permission_fk" FOREIGN KEY ("permission_id") REFERENCES "permissions" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "roles_permissions" ADD CONSTRAINT "role_fk_p" FOREIGN KEY ("role_id") REFERENCES "roles" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table uploadables
-- ----------------------------
ALTER TABLE "uploadables" ADD CONSTRAINT "uploadables_gen_upload_id" FOREIGN KEY ("gen_upload_id") REFERENCES "gen_uploads" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table user_activities
-- ----------------------------
ALTER TABLE "user_activities" ADD CONSTRAINT "user_activities_user_id" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table user_certificates
-- ----------------------------
ALTER TABLE "user_certificates" ADD CONSTRAINT "user_certificates_user_id" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table user_courses
-- ----------------------------
ALTER TABLE "user_courses" ADD CONSTRAINT "user_courses_user_id" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table user_profiles
-- ----------------------------
ALTER TABLE "user_profiles" ADD CONSTRAINT "user_profiles_user_id" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table users_roles
-- ----------------------------
ALTER TABLE "users_roles" ADD CONSTRAINT "role_fk" FOREIGN KEY ("role_id") REFERENCES "roles" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "users_roles" ADD CONSTRAINT "user_fk" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table setting_themes
-- ----------------------------
ALTER TABLE "setting_themes" ADD CONSTRAINT "setting_themes_user_id" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
