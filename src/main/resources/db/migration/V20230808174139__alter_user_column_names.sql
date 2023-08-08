ALTER TABLE users
    RENAME COLUMN firstName to first_name,
    RENAME COLUMN lastName to last_name ,
    RENAME COLUMN createdBy to created_by,
    RENAME COLUMN createdDate to created_date ,
    RENAME COLUMN lastModifiedBy to last_modified_by,
    RENAME COLUMN lastModifiedDate to last_modified_date;
