package by.it_academy.storage.sql;/* created by Kaminskii Ivan
 */

import by.it_academy.storage.api.DBCreator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreatDB implements DBCreator {
    private final DBInitializer dbInitializer = DBInitializer.getInstance();

    @Override
    public void newDB(String name) {
        try (Connection connection = dbInitializer.getCpds().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("" +

                    "-- Database: " + name + "\n" +
                    "\n" +
                    "-- DROP DATABASE " + name + ";\n" +
                    "\n" +
                    "CREATE DATABASE " + name + "\n" +
                    "    WITH \n" +
                    "    OWNER = postgres\n" +
                    "    ENCODING = 'UTF8'\n" +
                    "    LC_COLLATE = 'Russian_Russia.1251'\n" +
                    "    LC_CTYPE = 'Russian_Russia.1251'\n" +
                    "    TABLESPACE = pg_default\n" +
                    "    CONNECTION LIMIT = -1;");

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка создания базы данных", e);
        }
    }

    @Override
    public void depTable() {
        try (Connection connection = dbInitializer.getCpds().getConnection()
        ) {
            PreparedStatement statement = connection.prepareStatement("-- Table: application.departments\n" +
                    "\n" +
                    "-- DROP TABLE application.departments;\n" +
                    "\n" +
                    "CREATE TABLE IF NOT EXISTS application.departments\n" +
                    "(\n" +
                    "    id bigint NOT NULL DEFAULT nextval('application.departments_id_seq'::regclass),\n" +
                    "    name text COLLATE pg_catalog.\"default\",\n" +
                    "    parent_dep bigint,\n" +
                    "    CONSTRAINT departments_pkey PRIMARY KEY (id),\n" +
                    "    CONSTRAINT parent_dep_fkey FOREIGN KEY (parent_dep)\n" +
                    "        REFERENCES application.departments (id) MATCH SIMPLE\n" +
                    "        ON UPDATE NO ACTION\n" +
                    "        ON DELETE NO ACTION\n" +
                    "        NOT VALID\n" +
                    ")\n" +
                    "\n" +
                    "TABLESPACE pg_default;\n" +
                    "\n" +
                    "ALTER TABLE application.departments\n" +
                    "    OWNER to postgres;\n" +
                    "-- Index: fki_department_\n" +
                    "\n" +
                    "-- DROP INDEX application.fki_department_;\n" +
                    "\n" +
                    "CREATE INDEX IF NOT EXISTS fki_department_\n" +
                    "    ON application.departments USING btree\n" +
                    "    (parent_dep ASC NULLS LAST)\n" +
                    "    TABLESPACE pg_default;");

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void posTable() {
        try (Connection connection = dbInitializer.getCpds().getConnection()
        ) {
            PreparedStatement statement = connection.prepareStatement("-- Table: application.positions\n" +
                    "\n" +
                    "-- DROP TABLE application.positions;\n" +
                    "\n" +
                    "CREATE TABLE IF NOT EXISTS application.positions\n" +
                    "(\n" +
                    "    id bigint NOT NULL DEFAULT nextval('application.positions_id_seq'::regclass),\n" +
                    "    name text COLLATE pg_catalog.\"default\",\n" +
                    "    CONSTRAINT positions_pkey PRIMARY KEY (id)\n" +
                    ")\n" +
                    "\n" +
                    "TABLESPACE pg_default;\n" +
                    "\n" +
                    "ALTER TABLE application.positions\n" +
                    "    OWNER to postgres;");

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void empTable() {
        try (Connection connection = dbInitializer.getCpds().getConnection()
        ) {
            PreparedStatement statement = connection.prepareStatement("-- Table: application.employees\n" +
                    "\n" +
                    "-- DROP TABLE application.employees;\n" +
                    "\n" +
                    "CREATE TABLE IF NOT EXISTS application.employees\n" +
                    "(\n" +
                    "    id bigint NOT NULL DEFAULT nextval('application.employers_id_seq'::regclass),\n" +
                    "    name text COLLATE pg_catalog.\"default\",\n" +
                    "    salary numeric(10,2),\n" +
                    "    \"position\" bigint,\n" +
                    "    department bigint,\n" +
                    "    CONSTRAINT employers_pkey PRIMARY KEY (id),\n" +
                    "    CONSTRAINT department_fk FOREIGN KEY (department)\n" +
                    "        REFERENCES application.departments (id) MATCH SIMPLE\n" +
                    "        ON UPDATE NO ACTION\n" +
                    "        ON DELETE NO ACTION\n" +
                    "        NOT VALID,\n" +
                    "    CONSTRAINT position_fk FOREIGN KEY (\"position\")\n" +
                    "        REFERENCES application.positions (id) MATCH SIMPLE\n" +
                    "        ON UPDATE NO ACTION\n" +
                    "        ON DELETE NO ACTION\n" +
                    "        NOT VALID\n" +
                    ")\n" +
                    "\n" +
                    "TABLESPACE pg_default;\n" +
                    "\n" +
                    "ALTER TABLE application.employees\n" +
                    "    OWNER to postgres;\n" +
                    "-- Index: fki_department_fk\n" +
                    "\n" +
                    "-- DROP INDEX application.fki_department_fk;\n" +
                    "\n" +
                    "CREATE INDEX fki_department_fk\n" +
                    "    ON application.employees USING btree\n" +
                    "    (department ASC NULLS LAST)\n" +
                    "    TABLESPACE pg_default;\n" +
                    "-- Index: fki_position_fk\n" +
                    "\n" +
                    "-- DROP INDEX application.fki_position_fk;\n" +
                    "\n" +
                    "CREATE INDEX fki_position_fk\n" +
                    "    ON application.employees USING btree\n" +
                    "    (\"position\" ASC NULLS LAST)\n" +
                    "    TABLESPACE pg_default;");

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
