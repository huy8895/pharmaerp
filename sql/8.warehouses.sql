-- ----------------------------
-- Table structure for warehouses - has Many with tags
-- ----------------------------
DROP TABLE IF EXISTS "warehouses";
CREATE TABLE "warehouses"
(
    "id"             bigserial                                  NOT NULL,
    "name_vi"        varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
    "name_en"        varchar(255) COLLATE "pg_catalog"."default",
    "warehouse_code" varchar(45) COLLATE "pg_catalog"."default",
    "describe"       text COLLATE "pg_catalog"."default",
    "size"           int8,
    "height"         int8,
    "width"          int8,
    "length"         int8,
    "is_active"      boolean DEFAULT true,
    "created_at"     timestamp(6),
    "updated_at"     timestamp(6),
    "deleted_at"     timestamp(6)
)
;

COMMENT
ON COLUMN "warehouses"."size" is 'Quy mô nhà kho, đơn vị là m2';
COMMENT
ON COLUMN "warehouses"."height" is 'Chiều cao đơn vị mét';
COMMENT
ON COLUMN "warehouses"."width" is 'Chiều rộng đơn vị mét';
COMMENT
ON COLUMN "warehouses"."length" is 'Chiều dài đơn vị mét';

-- ----------------------------
-- Primary Key structure for table warehouses
-- ----------------------------
ALTER TABLE "warehouses"
    ADD CONSTRAINT "pk_warehouses" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table warehouses
-- ----------------------------
CREATE UNIQUE INDEX "warehouses_warehouse_code_unique" ON "warehouses" USING btree (
    "warehouse_code" COLLATE "pg_catalog"."default"
    "pg_catalog"."text_ops" ASC NULLS LAST
    );


-- ----------------------------
-- Table structure for warehouse_areas - Has file avatar
-- ----------------------------
DROP TABLE IF EXISTS "warehouse_areas";
CREATE TABLE "warehouse_areas"
(
    "id"                  bigserial                                  NOT NULL,
    "warehouse_id"        int8,
    "name_vi"             varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
    "name_en"             varchar(255) COLLATE "pg_catalog"."default",
    "warehouse_area_code" varchar(45) COLLATE "pg_catalog"."default",
    "describe"            text COLLATE "pg_catalog"."default",
    "is_active"           boolean DEFAULT true,
    "created_at"          timestamp(6),
    "updated_at"          timestamp(6),
    "deleted_at"          timestamp(6)
)
;

-- ----------------------------
-- Primary Key structure for table warehouse_areas
-- ----------------------------
ALTER TABLE "warehouse_areas"
    ADD CONSTRAINT "pk_warehouse_areas" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table documents
-- ----------------------------
ALTER TABLE "warehouse_areas"
    ADD CONSTRAINT "warehouse_areas_warehouse_id" FOREIGN KEY ("warehouse_id") REFERENCES "warehouses" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;