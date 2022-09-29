--INSERT INTO BOOK (id, title, author, description, price) VALUES
--  ("00000000-0000-0000-0000-000000000001" ,"Red Storm Rising", "Tom Clancy", "very good book", 15),
--  ("00000000-0000-0000-0000-000000000002" ,"The Bear And The Dragon", "Tom Clancy", "good book", 10);

insert into Book (id, title, author, description, price) values
  ('00000000-0000-0000-0000-000000000001' ,'Red Storm Rising', 'Tom Clancy', 'very good book', 15.12),
  ('00000000-0000-0000-0000-000000000002' ,'Storm Rising1', 'Tom Clancy1', 'very good book1', 14.12),
  ('00000000-0000-0000-0000-000000000003' ,'Red Storm Rising', 'm Clancy', 'very good book', 1512),
  ('00000000-0000-0000-0000-000000000004' ,'Red Storm Rising1', 'Tom Clancy1', 'very good book1', 5.12),
--  ('00000000-0000-0000-0000-000000000005' ,'ReStorm Rising', 'Tom Clancy', 'very good book', 15.1),
--  ('00000000-0000-0000-0000-000000000006' ,'Red Storm Rising', 'Tom Clancy', 'very good book', 1.12),
--  ('00000000-0000-0000-0000-000000000007' ,'Red Storm Rising1', 'Tom Clancy1', 'very good book1', 55.12),
--  ('00000000-0000-0000-0000-000000000008' ,'Red Stormising', 'ancy', ' good book', 15.13),
--  ('00000000-0000-0000-0000-000000000009' ,'Red Storm Rising1', 'Tom Clancy1', 'very good book1', 15.82),
--  ('00000000-0000-0000-0000-000000000010' ,'Red Storm Rising', 'Tom Clancy', 'very good book', 14.12),
--  ('00000000-0000-0000-0000-000000000011' ,'RStm Rising1', 'Tm Clancy1', 'very good book1', 15.24),
--  ('00000000-0000-0000-0000-000000000012' ,'Red Storm Rising', 'Tom Clancy', 'very good book', 15.12),
--  ('00000000-0000-0000-0000-000000000013' ,'Red Storm Rising1', 'Tom Clancy1', 'very good book1', 15.2),
--  ('00000000-0000-0000-0000-000000000014' ,'Red Storm Rising', 'To Clancy', 'very good book', 15.2),
--  ('00000000-0000-0000-0000-000000000016' ,'Red Storm Rising', 'Tom lancy', 'very good book', 152),
--  ('00000000-0000-0000-0000-000000000017' ,'Red Storm Rsing1', 'Tom Clancy1', 'very good book1', 12),
  ('00000000-0000-0000-0000-000000000018' ,'Redtorm Rising', 'Tom Clancy', 'very good book', 12),
  ('00000000-0000-0000-0000-000000000019' ,'Red Storm Rising1', 'm Clancy1', 'very good book1', 15.1),
  ('00000000-0000-0000-0000-000000000020' ,'Red Storm Rising', 'Tom Clancy', 'very good book', 15.2),
  ('00000000-0000-0000-0000-000000000021' ,'Red Storm Rising', 'Tom Clancy', 'very good book', 15.2),
  ('00000000-0000-0000-0000-000000000022' ,'Red Storm Rising1', 'Tom Clancy1', 'very good book1', 4.12);

insert into Users values
('user', '{bcrypt}$2a$12$ypenIMyjnld3/E2J0hxvsui08v.bglZhXLQtfZIa/bytHSOMnoDd6', '6666'), --pass
('admin', '{bcrypt}$2a$12$49UAOw8XjgLA/hyYROGQ4edX6XjUGvW1f8yHf6JQhH19ISQCGXbZG', '777'); --passs

insert into Role values
('user'),
('admin');

INSERT INTO users_roles values
('user', 'user'),
('admin', 'admin');
