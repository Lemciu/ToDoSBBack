INSERT INTO category
    (name)
VALUES
    ('Home'),
    ('Work'),
    ('Hobby');

INSERT INTO task
    (name, description, completed, alert, priority, due_date)
VALUES
    ('Learn Java', 'Loops, if statements, streams, lambda', true, false, 3, '2023-02-11 12:10:12'),
    ('Learn React', 'Django i inne Pythonowe bajery', false, false, 3, '2023-02-25 12:10:12'),
    ('Pomalować pokój', 'na biało', false, false, 2, '2023-02-28 10:10:10'),
    ('Iść na spotkanie w sprawie projektu X', 'omówić bugi i inne rzeczy', false, true, 3, '2023-03-03 10:10:10'),
    ('Zamówić dętki', '26, 27.5', false, true, 1, '2023-02-11 17:10:10'),
    ('Zamówić garnki', 'małe, duże do gotowania jedzonka', false, true, 1, '2023-02-11 17:10:10'),
    ('Wyrzucić śmieci', 'plasticzki do żółtego, skórki z bananów do bio ', false, false, 1, '2023-02-20 12:12:12'),
    ('Iść na trening', 'Klata plecy barki, od tego są ciężarki', false, false, 2, '2023-03-06 12:12:12');

INSERT INTO task_categories
    (task_id, categories_id)
VALUES
    (1, 2),
    (1, 3),
    (2, 2),
    (2, 3),
    (3, 3),
    (4, 2),
    (5, 3),
    (6, 1),
    (7, 1),
    (8, 3);
