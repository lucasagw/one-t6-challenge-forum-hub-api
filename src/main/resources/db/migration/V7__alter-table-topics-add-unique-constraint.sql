ALTER TABLE Topic
    ADD CONSTRAINT unique_title_message UNIQUE (title, message);
