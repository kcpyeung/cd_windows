-- dbdeploy will wrap the application of each change script
-- in a transaction
--
-- DML statements (INSERT, UPDATE etc) can be applied transactionally,
-- so therefore dbdeploy will ensure that either the whole of this script applies
-- or none of it does.
--
INSERT INTO Test VALUES (8, 'I came here for an argument');
INSERT INTO Test VALUES (9, 'My hovercraft is full of eels');

--//@UNDO

DELETE FROM Test WHERE id IN (8,9);

