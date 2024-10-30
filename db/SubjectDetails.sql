-- public.subject_details definition

-- Drop table

-- DROP TABLE public.subject_details;

CREATE TABLE public.subject_details (
	id uuid NOT NULL,
	upk varchar(255) NOT NULL,
	flagged boolean NOT NULL,
	given_names varchar(50) NOT NULL,
	family_name varchar(50) NOT NULL,
	date_of_birth varchar(10) NOT NULL,
	gender varchar(1) NOT NULL,
	nationality varchar(30) NULL,
	document_type varchar(1) NOT NULL,
	document_number varchar(20) NOT NULL,
	issuing_state varchar(50) NULL,
	expiry_date varchar(10) NOT NULL,
	itinerary varchar NULL,
	assessment varchar NULL,
	CONSTRAINT subject_details_pkey PRIMARY KEY (id)
);

