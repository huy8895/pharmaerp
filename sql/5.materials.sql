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