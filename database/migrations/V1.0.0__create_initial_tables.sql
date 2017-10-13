
CREATE TABLE users (
  id INT,
  first_name VARCHAR(20) NOT NULL,
  last_name VARCHAR(20)  NOT NULL,
  email VARCHAR(50)  NOT NULL,
  created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP(3),
  updated_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP(3)
);

CREATE TABLE locations (
  id INT,
  name VARCHAR(50) NOT NULL,
  address VARCHAR(50),
  city VARCHAR(30),
  state VARCHAR(2),
  zip VARCHAR(10),
  created_by VARCHAR(50) NOT NULL,
  created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP(3),
  updated_by  VARCHAR(50) NOT NULL,
  updated_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP(3)
);

CREATE TABLE menu_items (
  id INT,
  location_id INT,
  name VARCHAR(50) NOT NULL,
  description TEXT,
  created_by VARCHAR(50) NOT NULL,
  created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP(3),
  updated_by  VARCHAR(50) NOT NULL,
  updated_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP(3)
);

CREATE TABLE reviews (
  id INT,
  location_id INT,
  menu_item_id INT,
  description TEXT,
  value INT,
  created_by VARCHAR(50) NOT NULL,
  created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP(3),
  updated_by  VARCHAR(50) NOT NULL,
  updated_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP(3)
);

CREATE TABLE favorites (
  id INT,
  user_id INT,
  location_id INT,
  menu_item_id INT,
  review_id INT,
  created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP(3)
);

CREATE TABLE images (
  id INT,
  cloudinary_id VARCHAR(50),
  location_id INT,
  menu_item_id INT,
  review_id INT,
  created_by VARCHAR(50) NOT NULL,
  created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP(3)
);