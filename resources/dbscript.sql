CREATE TABLE user_review(
	id BIGINT AUTO_INCREMENT,
    order_id BIGINT,
    product_id BIGINT,
    user_id BIGINT,
    rating FLOAT,
    review VARCHAR(255),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    CONSTRAINT chk_Rating CHECK (rating >= 1 AND rating <= 5)
)