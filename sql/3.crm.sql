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