create table Medicaid_Document (
	documentId LONG not null primary key,
	docName VARCHAR(75) null,
	fileId LONG,
	fileUrl VARCHAR(75) null,
	patientId LONG,
	createDate DATE null,
	createdBy VARCHAR(75) null,
	modifiedDate DATE null,
	modifiedBy VARCHAR(75) null
);

create table Medicaid_Facility (
	facilityId LONG not null primary key,
	name VARCHAR(75) null,
	address VARCHAR(75) null,
	city VARCHAR(75) null,
	state_ VARCHAR(75) null,
	zipcode VARCHAR(75) null,
	phoneNumber LONG,
	faxNumber VARCHAR(75) null,
	email VARCHAR(75) null,
	pointOfContact VARCHAR(75) null,
	createDate DATE null,
	createdBy VARCHAR(75) null,
	modifiedDate DATE null,
	modifiedBy VARCHAR(75) null
);

create table Medicaid_FacilityAdmin (
	userName VARCHAR(75) not null primary key,
	email VARCHAR(75) null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	phoneNumber LONG,
	title VARCHAR(75) null,
	facilityIds VARCHAR(75) null,
	createDate DATE null,
	createdBy VARCHAR(75) null,
	modifiedDate DATE null,
	modifiedBy VARCHAR(75) null
);

create table Medicaid_Note (
	noteId LONG not null primary key,
	referralId LONG,
	commentDate DATE null,
	comments VARCHAR(75) null,
	createDate DATE null,
	createdBy VARCHAR(75) null,
	modifiedDate DATE null,
	modifiedBy VARCHAR(75) null
);

create table Medicaid_Patient (
	patientId LONG not null primary key,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	phoneNo LONG,
	dateOfBirth DATE null,
	admitDate DATE null,
	admitPayer VARCHAR(75) null,
	medicaidNeedDate DATE null,
	haveMedicaid BOOLEAN,
	residentLiabilityEmailSent BOOLEAN,
	address VARCHAR(75) null,
	city VARCHAR(75) null,
	state_ VARCHAR(75) null,
	zipCode VARCHAR(75) null,
	documentIds VARCHAR(75) null,
	referralId LONG,
	facilityId VARCHAR(75) null,
	createDate DATE null,
	createdBy VARCHAR(75) null,
	modifiedDate DATE null,
	modifiedBy VARCHAR(75) null
);

create table Medicaid_Referral (
	referralId LONG not null primary key,
	dateReferred DATE null,
	submitDate DATE null,
	approvedDate DATE null,
	pendingDate DATE null,
	status VARCHAR(75) null,
	cocEmailSent VARCHAR(75) null,
	resLiability DOUBLE,
	emailSentDueDate DATE null,
	facilityAdmin VARCHAR(75) null,
	facilities VARCHAR(75) null,
	patientId LONG,
	noteId LONG,
	createDate DATE null,
	createdBy VARCHAR(75) null,
	modifiedDate DATE null,
	modifiedBy VARCHAR(75) null
);