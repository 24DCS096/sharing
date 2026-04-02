CREATE TABLE Contacts (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT UNIQUE NOT NULL,
    email TEXT NOT NULL,
    isBorrower BOOLEAN DEFAULT 0
);

CREATE TABLE Items (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    status TEXT CHECK(status IN ('Available', 'Borrowed')) NOT NULL,
    borrower_id INTEGER,
    FOREIGN KEY (borrower_id) REFERENCES Contacts(id)
);

CREATE TABLE Dimensions (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    item_id INTEGER,
    width TEXT,
    height TEXT,
    length TEXT,
    FOREIGN KEY (item_id) REFERENCES Items(id)
);
