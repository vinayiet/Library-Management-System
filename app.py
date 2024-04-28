from flask import Flask, render_template
import psycopg2

app = Flask(__name__, template_folder='templates')

# Function to connect to the PostgreSQL database
def connect():
    try:
        db = psycopg2.connect(
            dbname="library",
            user="postgres",
            password="12345678",
            host="localhost",
            port="5432"
        )
        return db
    except psycopg2.Error as e:
        print("Error connecting to the database:", e)
        return None

@app.route('/')
def home():
    return render_template('home.html')

@app.route('/students')
def students():
    conn = connect()
    if conn is None:
        return "Error: Unable to connect to the database."
    
    try:
        cursor = conn.cursor()
        cursor.execute("SELECT * FROM Student")  # Assuming the table name is "Student"
        students = cursor.fetchall()
        cursor.close()
        conn.close()
        return render_template('students_list.html', students=students)
    except psycopg2.Error as e:
        print("Error executing SQL query:", e)
        conn.close()
        return "Error: Unable to fetch students data."

@app.route('/books')
def booklist():
    return render_template('book_list.html')

@app.route('/transactions')
def transactions():
    return render_template('transactions.html')

if __name__ == '__main__':
    app.run(debug=True)
