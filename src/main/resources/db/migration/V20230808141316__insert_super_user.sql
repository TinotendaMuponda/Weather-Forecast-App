INSERT INTO users(id,
                  username,
                  firstName,
                  lastName,
                  country,
                  city,
                  createdBy,
                  createdDate,
                  lastModifiedBy,
                  lastModifiedDate,
                  role,
                  password)
VALUES (
        1,
        'admin',
        '',
        '',
        '',
        '',
        'sys',
        sysdate(),
        '',
        sysdate(),
        'ADMIN',
        '$2a$12$IxfshnQ8ejEiaWZTpREZpeVqtfL34C2KbdxfhWqJq6xiMvt7PmsOW'
        )