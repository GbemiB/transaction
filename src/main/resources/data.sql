INSERT INTO online_bank.account (id, sort_code, account_number, current_balance, bank_name, owner_name)
VALUES (1, '53-68-92', '73084635', 1071.78, 'Challenger Bank', 'Paul Dragoslav');
INSERT INTO online_bank.account (id, sort_code, account_number, current_balance, bank_name, owner_name)
VALUES (2, '65-93-37', '21956204', 67051.01, 'High Street Bank', 'Scrooge McDuck');
INSERT INTO online_bank.account (id, sort_code, account_number, current_balance, bank_name, owner_name)
VALUES (3, '69-90-35', '26789044', 99051.01, 'Polaray Bank', 'Jakes Bones');
INSERT INTO online_bank.account (id, sort_code, account_number, current_balance, bank_name, owner_name)
VALUES (4, '90-90-35', '26785678', 12345.01, 'Highway Bank', 'Luke James');
INSERT INTO online_bank.account (id, sort_code, account_number, current_balance, bank_name, owner_name)
VALUES (5, '70-90-35', '26789853', 67876.01, 'Texas Bank', 'Stone Germey');


INSERT INTO online_bank.transaction (id, source_account_id, target_account_id, source_owner_name, source_country, target_owner_name, target_country, currency, amount, initiation_date, completion_date, reference, comment, latitude, longitude)
VALUES (1, 1, 2, 'Scrooge McDuck', 'USA','Mary Cakes','NGA','naira','2340','2019-04-01 10:30', '2019-04-01 10:54', 'Protection charge Apr', 'success',56, 56);

INSERT INTO online_bank.transaction (id, source_account_id, target_account_id, source_owner_name, source_country, target_owner_name, target_country, currency, amount, initiation_date, completion_date, reference, comment, latitude, longitude)
VALUES (2, 2, 2, 'Scrooge McDuck', 'USA','Mary Cakes','NGA','naira','2340','2019-04-01 10:30', '2019-04-01 10:54', 'Protection charge Apr', 'success',56, 56);

INSERT INTO online_bank.transaction (id, source_account_id, target_account_id, source_owner_name, source_country, target_owner_name, target_country, currency, amount, initiation_date, completion_date, reference, comment, latitude, longitude)
VALUES (3, 3, 2, 'Scrooge McDuck', 'USA','Mary Cakes','NGA','naira','2340','2019-04-01 10:30', '2019-04-01 10:54', 'Protection charge Apr', 'success',56, 56);

INSERT INTO online_bank.transaction (id, source_account_id, target_account_id, source_owner_name, source_country, target_owner_name, target_country, currency, amount, initiation_date, completion_date, reference, comment, latitude, longitude)
VALUES (4, 4, 4, 'Stone Germey', 'USA','Mary Cakes','NGA','naira','2340','2019-04-01 10:30', '2019-04-01 10:54', 'Protection charge Apr', 'success',56, 56);

