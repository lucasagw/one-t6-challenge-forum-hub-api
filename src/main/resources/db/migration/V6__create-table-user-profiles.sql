CREATE TABLE user_profiles (
    user_id BIGINT NOT NULL,
    profile_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, profile_id),
    CONSTRAINT fk_user_profiles_user_id FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_user_profiles_profile_id FOREIGN KEY (profile_id) REFERENCES profiles(id)
);
