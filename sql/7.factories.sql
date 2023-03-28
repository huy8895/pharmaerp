-- ----------------------------
-- Table structure for factories - has Many with tags
-- ----------------------------
DROP TABLE IF EXISTS "factories";
CREATE TABLE "factories"
(
    "id"           bigserial                                  NOT NULL,
    "name_vi"      varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
    "name_en"      varchar(255) COLLATE "pg_catalog"."default",
    "factory_code" varchar(45) COLLATE "pg_catalog"."default",
    "describe"     text COLLATE "pg_catalog"."default",
    "is_active"    boolean DEFAULT true,
    "created_at"   timestamp(6),
    "updated_at"   timestamp(6),
    "deleted_at"   timestamp(6)
)
;

-- ----------------------------
-- Primary Key structure for table factories
-- ----------------------------
ALTER TABLE "factories"
    ADD CONSTRAINT "pk_factories" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table factories
-- ----------------------------
CREATE UNIQUE INDEX "factories_factory_code_unique" ON "factories" USING btree (
    "factory_code" COLLATE "pg_catalog"."default"
    "pg_catalog"."text_ops" ASC NULLS LAST
    );


-- ----------------------------
-- Table structure for factory_lines - Has file avatar
-- ----------------------------
DROP TABLE IF EXISTS "factory_lines";
CREATE TABLE "factory_lines"
(
    "id"                bigserial                                  NOT NULL,
    "factory_id"        int8                                       NOT NULL,
    "name_vi"           varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
    "name_en"           varchar(255) COLLATE "pg_catalog"."default",
    "factory_line_code" varchar(45) COLLATE "pg_catalog"."default",
    "describe"          text COLLATE "pg_catalog"."default",
    "is_active"         boolean DEFAULT true,
    "created_at"        timestamp(6),
    "updated_at"        timestamp(6),
    "deleted_at"        timestamp(6)
)
;

-- ----------------------------
-- Primary Key structure for table factory_lines
-- ----------------------------
ALTER TABLE "factory_lines"
    ADD CONSTRAINT "pk_factory_lines" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table documents
-- ----------------------------
ALTER TABLE "factory_lines"
    ADD CONSTRAINT "factory_lines_factory_id" FOREIGN KEY ("factory_id") REFERENCES "factorys" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;