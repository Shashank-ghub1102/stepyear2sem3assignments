import sqlite3

# 1. Connect to database file (creates it automatically if it doesn't exist)
conn = sqlite3.connect('Test.db')
cursor = conn.cursor()

# 2. CREATE TABLE
cursor.execute('''
    CREATE TABLE IF NOT EXISTS STUDENT (
        ID INT PRIMARY KEY NOT NULL,
        NAME TEXT NOT NULL,
        AGE INT NOT NULL,
        FEES REAL
    )
''')
print("Table created successfully!")

# 3. INSERT (Create)
cursor.execute("INSERT INTO STUDENT VALUES (1, 'Ajeet', 21, 10000.0)")
cursor.execute("INSERT INTO STUDENT VALUES (2, 'Akash', 22, 15000.0)")
conn.commit()
print("Records inserted!")

# 4. SELECT (Read)
cursor.execute("SELECT * FROM STUDENT")
rows = cursor.fetchall()
print("\n--- Current Records ---")
for row in rows:
    print(row)

# 5. UPDATE
cursor.execute("UPDATE STUDENT SET FEES = 12000.0 WHERE ID = 1")
conn.commit()
print("\nRecord ID 1 updated!")

# 6. DELETE
cursor.execute("DELETE FROM STUDENT WHERE ID = 2")
conn.commit()
print("Record ID 2 deleted!")

# Verify Final State
cursor.execute("SELECT * FROM STUDENT")
print("\n--- Final Records ---")
print(cursor.fetchall())

# Close Connection
conn.close()