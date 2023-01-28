create index IX_BBCE2606 on Medicaid_Document (patientId);

create index IX_1DA0188D on Medicaid_Note (referralId);

create index IX_D1EA654E on Medicaid_Patient (emailAddress[$COLUMN_LENGTH:75$]);
create index IX_B7E3E734 on Medicaid_Patient (facilityId[$COLUMN_LENGTH:75$]);
create index IX_1ED0E9 on Medicaid_Patient (firstName[$COLUMN_LENGTH:75$]);
create index IX_A622DE97 on Medicaid_Patient (lastName[$COLUMN_LENGTH:75$]);

create index IX_6E5F4B21 on Medicaid_Referral (facilities[$COLUMN_LENGTH:75$]);
create index IX_3F796752 on Medicaid_Referral (status[$COLUMN_LENGTH:75$]);