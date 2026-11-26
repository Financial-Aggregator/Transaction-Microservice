CREATE TABLE processed_events (
                                 idempotency_key UUID PRIMARY KEY,
                                 processed_at TIMESTAMP NOT NULL DEFAULT now()
);

CREATE INDEX idx_processed_events_event_id ON processed_events (idempotency_key);