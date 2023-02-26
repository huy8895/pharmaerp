/*
 Navicat Premium Data Transfer

 Source Server         : PgConnect
 Source Server Type    : PostgreSQL
 Source Server Version : 140005
 Source Host           : localhost:5432
 Source Catalog        : postgres
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 140005
 File Encoding         : 65001

 Date: 26/02/2023 15:03:08
*/


-- ----------------------------
-- Sequence structure for activity_logs_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."activity_logs_id_seq";
CREATE SEQUENCE "public"."activity_logs_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for contract_types_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."contract_types_id_seq";
CREATE SEQUENCE "public"."contract_types_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for contracts_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."contracts_id_seq";
CREATE SEQUENCE "public"."contracts_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for gen_departments_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."gen_departments_id_seq";
CREATE SEQUENCE "public"."gen_departments_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for gen_job_titles_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."gen_job_titles_id_seq";
CREATE SEQUENCE "public"."gen_job_titles_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for gen_officer_levels_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."gen_officer_levels_id_seq";
CREATE SEQUENCE "public"."gen_officer_levels_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for gen_uploads_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."gen_uploads_id_seq";
CREATE SEQUENCE "public"."gen_uploads_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for gen_work_locations_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."gen_work_locations_id_seq";
CREATE SEQUENCE "public"."gen_work_locations_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for privileges_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."privileges_id_seq";
CREATE SEQUENCE "public"."privileges_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for roles_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."roles_id_seq";
CREATE SEQUENCE "public"."roles_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for user_activities_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."user_activities_id_seq";
CREATE SEQUENCE "public"."user_activities_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for user_certificates_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."user_certificates_id_seq";
CREATE SEQUENCE "public"."user_certificates_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for user_courses_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."user_courses_id_seq";
CREATE SEQUENCE "public"."user_courses_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for user_profiles_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."user_profiles_id_seq";
CREATE SEQUENCE "public"."user_profiles_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for users_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."users_id_seq";
CREATE SEQUENCE "public"."users_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for activity_logs
-- ----------------------------
DROP TABLE IF EXISTS "public"."activity_logs";
CREATE TABLE "public"."activity_logs" (
  "id" int8 NOT NULL DEFAULT nextval('activity_logs_id_seq'::regclass),
  "ip" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "user-agent" text COLLATE "pg_catalog"."default",
  "request" text COLLATE "pg_catalog"."default",
  "response" text COLLATE "pg_catalog"."default",
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "deleted_at" timestamp(6),
  "user_id" int8
)
;

-- ----------------------------
-- Table structure for contract_types
-- ----------------------------
DROP TABLE IF EXISTS "public"."contract_types";
CREATE TABLE "public"."contract_types" (
  "id" int8 NOT NULL DEFAULT nextval('contract_types_id_seq'::regclass),
  "name" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "is_determine_deadline" int2 NOT NULL DEFAULT 0,
  "is_active" int2 NOT NULL DEFAULT 1,
  "describe" text COLLATE "pg_catalog"."default",
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for contracts
-- ----------------------------
DROP TABLE IF EXISTS "public"."contracts";
CREATE TABLE "public"."contracts" (
  "id" int8 NOT NULL DEFAULT nextval('contracts_id_seq'::regclass),
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

-- ----------------------------
-- Table structure for gen_departments
-- ----------------------------
DROP TABLE IF EXISTS "public"."gen_departments";
CREATE TABLE "public"."gen_departments" (
  "id" int8 NOT NULL DEFAULT nextval('gen_departments_id_seq'::regclass),
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "describe" text COLLATE "pg_catalog"."default",
  "is_active" int2 NOT NULL DEFAULT 1,
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for gen_job_titles
-- ----------------------------
DROP TABLE IF EXISTS "public"."gen_job_titles";
CREATE TABLE "public"."gen_job_titles" (
  "id" int8 NOT NULL DEFAULT nextval('gen_job_titles_id_seq'::regclass),
  "name" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "salary" int8,
  "describe" text COLLATE "pg_catalog"."default",
  "is_active" int2 NOT NULL DEFAULT 1,
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for gen_officer_levels
-- ----------------------------
DROP TABLE IF EXISTS "public"."gen_officer_levels";
CREATE TABLE "public"."gen_officer_levels" (
  "id" int8 NOT NULL DEFAULT nextval('gen_officer_levels_id_seq'::regclass),
  "name" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "describe" text COLLATE "pg_catalog"."default",
  "is_active" int2 NOT NULL DEFAULT 1,
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for gen_uploads
-- ----------------------------
DROP TABLE IF EXISTS "public"."gen_uploads";
CREATE TABLE "public"."gen_uploads" (
  "id" int8 NOT NULL DEFAULT nextval('gen_uploads_id_seq'::regclass),
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
DROP TABLE IF EXISTS "public"."gen_work_locations";
CREATE TABLE "public"."gen_work_locations" (
  "id" int8 NOT NULL DEFAULT nextval('gen_work_locations_id_seq'::regclass),
  "name" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "describe" text COLLATE "pg_catalog"."default",
  "is_active" int2 NOT NULL DEFAULT 1,
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for privileges
-- ----------------------------
DROP TABLE IF EXISTS "public"."privileges";
CREATE TABLE "public"."privileges" (
  "id" int8 NOT NULL DEFAULT nextval('privileges_id_seq'::regclass),
  "group" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "key" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "is_active" int2 NOT NULL DEFAULT 1,
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS "public"."roles";
CREATE TABLE "public"."roles" (
  "id" int8 NOT NULL DEFAULT nextval('roles_id_seq'::regclass),
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "describe" text COLLATE "pg_catalog"."default",
  "is_default" int2 NOT NULL DEFAULT 0,
  "is_active" int2 NOT NULL DEFAULT 1,
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for roles_privileges
-- ----------------------------
DROP TABLE IF EXISTS "public"."roles_privileges";
CREATE TABLE "public"."roles_privileges" (
  "role_id" int8 NOT NULL,
  "privilege_id" int8 NOT NULL
)
;

-- ----------------------------
-- Table structure for uploadables
-- ----------------------------
DROP TABLE IF EXISTS "public"."uploadables";
CREATE TABLE "public"."uploadables" (
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
DROP TABLE IF EXISTS "public"."user_activities";
CREATE TABLE "public"."user_activities" (
  "id" int8 NOT NULL DEFAULT nextval('user_activities_id_seq'::regclass),
  "user_id" int8 NOT NULL,
  "organization" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "participating_position" varchar(255) COLLATE "pg_catalog"."default",
  "is_current_active" int2 DEFAULT 0,
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
DROP TABLE IF EXISTS "public"."user_certificates";
CREATE TABLE "public"."user_certificates" (
  "id" int8 NOT NULL DEFAULT nextval('user_certificates_id_seq'::regclass),
  "user_id" int8 NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "organization" varchar(255) COLLATE "pg_catalog"."default",
  "has_no_expiration_date" int2 DEFAULT 1,
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
DROP TABLE IF EXISTS "public"."user_courses";
CREATE TABLE "public"."user_courses" (
  "id" int8 NOT NULL DEFAULT nextval('user_courses_id_seq'::regclass),
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
DROP TABLE IF EXISTS "public"."user_profiles";
CREATE TABLE "public"."user_profiles" (
  "id" int8 NOT NULL DEFAULT nextval('user_profiles_id_seq'::regclass),
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
DROP TABLE IF EXISTS "public"."users";
CREATE TABLE "public"."users" (
  "id" int8 NOT NULL DEFAULT nextval('users_id_seq'::regclass),
  "username" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "email" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "staff_code" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "phone_number" varchar(45) COLLATE "pg_catalog"."default",
  "password" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "type" varchar(45) COLLATE "pg_catalog"."default" NOT NULL,
  "first_name" varchar(45) COLLATE "pg_catalog"."default" NOT NULL,
  "last_name" varchar(45) COLLATE "pg_catalog"."default" NOT NULL,
  "is_active" int2 DEFAULT 1,
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "deleted_at" timestamp(6)
)
;

-- ----------------------------
-- Table structure for users_roles
-- ----------------------------
DROP TABLE IF EXISTS "public"."users_roles";
CREATE TABLE "public"."users_roles" (
  "user_id" int8 NOT NULL,
  "role_id" int8 NOT NULL
)
;

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."activity_logs_id_seq"
OWNED BY "public"."activity_logs"."id";
SELECT setval('"public"."activity_logs_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."contract_types_id_seq"
OWNED BY "public"."contract_types"."id";
SELECT setval('"public"."contract_types_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."contracts_id_seq"
OWNED BY "public"."contracts"."id";
SELECT setval('"public"."contracts_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."gen_departments_id_seq"
OWNED BY "public"."gen_departments"."id";
SELECT setval('"public"."gen_departments_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."gen_job_titles_id_seq"
OWNED BY "public"."gen_job_titles"."id";
SELECT setval('"public"."gen_job_titles_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."gen_officer_levels_id_seq"
OWNED BY "public"."gen_officer_levels"."id";
SELECT setval('"public"."gen_officer_levels_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."gen_uploads_id_seq"
OWNED BY "public"."gen_uploads"."id";
SELECT setval('"public"."gen_uploads_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."gen_work_locations_id_seq"
OWNED BY "public"."gen_work_locations"."id";
SELECT setval('"public"."gen_work_locations_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."privileges_id_seq"
OWNED BY "public"."privileges"."id";
SELECT setval('"public"."privileges_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."roles_id_seq"
OWNED BY "public"."roles"."id";
SELECT setval('"public"."roles_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."user_activities_id_seq"
OWNED BY "public"."user_activities"."id";
SELECT setval('"public"."user_activities_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."user_certificates_id_seq"
OWNED BY "public"."user_certificates"."id";
SELECT setval('"public"."user_certificates_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."user_courses_id_seq"
OWNED BY "public"."user_courses"."id";
SELECT setval('"public"."user_courses_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."user_profiles_id_seq"
OWNED BY "public"."user_profiles"."id";
SELECT setval('"public"."user_profiles_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."users_id_seq"
OWNED BY "public"."users"."id";
SELECT setval('"public"."users_id_seq"', 1, false);

-- ----------------------------
-- Indexes structure for table activity_logs
-- ----------------------------
CREATE INDEX "activity_logs_user_id_idx" ON "public"."activity_logs" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table activity_logs
-- ----------------------------
ALTER TABLE "public"."activity_logs" ADD CONSTRAINT "activity_logs_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table contract_types
-- ----------------------------
CREATE UNIQUE INDEX "name_unique" ON "public"."contract_types" USING btree (
  "name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table contract_types
-- ----------------------------
ALTER TABLE "public"."contract_types" ADD CONSTRAINT "pk_contract_types" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table contracts
-- ----------------------------
CREATE INDEX "contracts_contract_type_id_idx" ON "public"."contracts" USING btree (
  "contract_type_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "contracts_creator_id_idx" ON "public"."contracts" USING btree (
  "creator_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "contracts_gen_job_title_id_idx" ON "public"."contracts" USING btree (
  "gen_job_title_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "contracts_gen_officer_level_id_idx" ON "public"."contracts" USING btree (
  "gen_officer_level_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "contracts_gen_work_location_id_idx" ON "public"."contracts" USING btree (
  "gen_work_location_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE UNIQUE INDEX "contracts_user_id_unique" ON "public"."contracts" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table contracts
-- ----------------------------
ALTER TABLE "public"."contracts" ADD CONSTRAINT "pk_contracts" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table gen_departments
-- ----------------------------
ALTER TABLE "public"."gen_departments" ADD CONSTRAINT "gen_departments_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table gen_job_titles
-- ----------------------------
ALTER TABLE "public"."gen_job_titles" ADD CONSTRAINT "pk_gen_job_titles" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table gen_officer_levels
-- ----------------------------
ALTER TABLE "public"."gen_officer_levels" ADD CONSTRAINT "pk_gen_officer_levels" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table gen_uploads
-- ----------------------------
CREATE UNIQUE INDEX "original_name_unique" ON "public"."gen_uploads" USING btree (
  "original_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table gen_uploads
-- ----------------------------
ALTER TABLE "public"."gen_uploads" ADD CONSTRAINT "pk_gen_uploads" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table gen_work_locations
-- ----------------------------
ALTER TABLE "public"."gen_work_locations" ADD CONSTRAINT "pk_gen_work_locations" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table privileges
-- ----------------------------
ALTER TABLE "public"."privileges" ADD CONSTRAINT "pk_privileges" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table roles
-- ----------------------------
ALTER TABLE "public"."roles" ADD CONSTRAINT "pk_roles" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table roles_privileges
-- ----------------------------
CREATE INDEX "roles_privileges_privilege_id_idx" ON "public"."roles_privileges" USING btree (
  "privilege_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "roles_privileges_role_id_idx" ON "public"."roles_privileges" USING btree (
  "role_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table roles_privileges
-- ----------------------------
ALTER TABLE "public"."roles_privileges" ADD CONSTRAINT "pk_roles_privileges" PRIMARY KEY ("role_id", "privilege_id");

-- ----------------------------
-- Primary Key structure for table uploadables
-- ----------------------------
ALTER TABLE "public"."uploadables" ADD CONSTRAINT "pk_uploadables" PRIMARY KEY ("gen_upload_id", "object_id");

-- ----------------------------
-- Indexes structure for table user_activities
-- ----------------------------
CREATE INDEX "user_activities_user_id_idx" ON "public"."user_activities" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table user_activities
-- ----------------------------
ALTER TABLE "public"."user_activities" ADD CONSTRAINT "pk_user_activities" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table user_certificates
-- ----------------------------
CREATE INDEX "user_certificates_user_id_idx" ON "public"."user_certificates" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table user_certificates
-- ----------------------------
ALTER TABLE "public"."user_certificates" ADD CONSTRAINT "pk_user_certificates" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table user_courses
-- ----------------------------
CREATE INDEX "user_courses_user_id_idx" ON "public"."user_courses" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table user_courses
-- ----------------------------
ALTER TABLE "public"."user_courses" ADD CONSTRAINT "pk_user_courses" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table user_profiles
-- ----------------------------
ALTER TABLE "public"."user_profiles" ADD CONSTRAINT "pk_user_profiles" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table users
-- ----------------------------
CREATE UNIQUE INDEX "email_unique" ON "public"."users" USING btree (
  "email" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE UNIQUE INDEX "username_unique" ON "public"."users" USING btree (
  "username" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table users
-- ----------------------------
ALTER TABLE "public"."users" ADD CONSTRAINT "pk_users" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table users_roles
-- ----------------------------
CREATE INDEX "role_fk" ON "public"."users_roles" USING btree (
  "role_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table users_roles
-- ----------------------------
ALTER TABLE "public"."users_roles" ADD CONSTRAINT "pk_users_roles" PRIMARY KEY ("user_id", "role_id");

-- ----------------------------
-- Foreign Keys structure for table contracts
-- ----------------------------
ALTER TABLE "public"."contracts" ADD CONSTRAINT "contracts_contract_type_id" FOREIGN KEY ("contract_type_id") REFERENCES "public"."contract_types" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."contracts" ADD CONSTRAINT "contracts_creator_id" FOREIGN KEY ("creator_id") REFERENCES "public"."users" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "public"."contracts" ADD CONSTRAINT "contracts_gen_job_title_id" FOREIGN KEY ("gen_job_title_id") REFERENCES "public"."gen_job_titles" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "public"."contracts" ADD CONSTRAINT "contracts_gen_officer_level_id" FOREIGN KEY ("gen_officer_level_id") REFERENCES "public"."gen_officer_levels" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "public"."contracts" ADD CONSTRAINT "contracts_gen_work_location_id" FOREIGN KEY ("gen_work_location_id") REFERENCES "public"."gen_work_locations" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "public"."contracts" ADD CONSTRAINT "contracts_user_id" FOREIGN KEY ("user_id") REFERENCES "public"."users" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table roles_privileges
-- ----------------------------
ALTER TABLE "public"."roles_privileges" ADD CONSTRAINT "privilege_fk" FOREIGN KEY ("privilege_id") REFERENCES "public"."privileges" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "public"."roles_privileges" ADD CONSTRAINT "role_fk_p" FOREIGN KEY ("role_id") REFERENCES "public"."roles" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table uploadables
-- ----------------------------
ALTER TABLE "public"."uploadables" ADD CONSTRAINT "uploadables_gen_upload_id" FOREIGN KEY ("gen_upload_id") REFERENCES "public"."gen_uploads" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table user_activities
-- ----------------------------
ALTER TABLE "public"."user_activities" ADD CONSTRAINT "user_activities_user_id" FOREIGN KEY ("user_id") REFERENCES "public"."users" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table user_certificates
-- ----------------------------
ALTER TABLE "public"."user_certificates" ADD CONSTRAINT "user_certificates_user_id" FOREIGN KEY ("user_id") REFERENCES "public"."users" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table user_courses
-- ----------------------------
ALTER TABLE "public"."user_courses" ADD CONSTRAINT "user_courses_user_id" FOREIGN KEY ("user_id") REFERENCES "public"."users" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table user_profiles
-- ----------------------------
ALTER TABLE "public"."user_profiles" ADD CONSTRAINT "user_profiles_user_id" FOREIGN KEY ("user_id") REFERENCES "public"."users" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table users_roles
-- ----------------------------
ALTER TABLE "public"."users_roles" ADD CONSTRAINT "role_fk" FOREIGN KEY ("role_id") REFERENCES "public"."roles" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "public"."users_roles" ADD CONSTRAINT "user_fk" FOREIGN KEY ("user_id") REFERENCES "public"."users" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
