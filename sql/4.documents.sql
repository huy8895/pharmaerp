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