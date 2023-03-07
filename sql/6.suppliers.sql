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