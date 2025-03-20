let bookID = 4; // Start with book ID 4 since 1-3 are already listed
 
    function addBook() {
        let name = document.getElementById("bookName").value.trim();
        let author = document.getElementById("author").value.trim();
        let price = document.getElementById("price").value.trim();
 
        if (!name || !author || !price) {
            alert("Please fill all fields!");
            return;
        }
 
        let table = document.getElementById("bookList");
        let row = `<tr>
                    <td>${bookID}</td>
                    <td>${name}</td>
                    <td>${author}</td>
                    <td>${price}/-</td>
                </tr>`;
        table.innerHTML += row;
        bookID++; 
 
        // Clear input fields
        document.getElementById("bookName").value = "";
        document.getElementById("author").value = "";
        document.getElementById("price").value = "";
    }
 
    function searchBook() {
        let searchID = document.getElementById("searchBookId").value.trim();
        let table = document.getElementById("booksTable").getElementsByTagName("tbody")[0];
        let rows = table.getElementsByTagName("tr");
        let resultDiv = document.getElementById("searchResult");
        resultDiv.innerHTML = ""; 
 
        for (let row of rows) {
            let id = row.getElementsByTagName("td")[0].textContent;
            if (id === searchID) {
                resultDiv.innerHTML = `<p>📘 <strong>${row.getElementsByTagName("td")[1].textContent}</strong> by ${row.getElementsByTagName("td")[2].textContent}, Price: ${row.getElementsByTagName("td")[3].textContent}</p>`;
                return;
            }
        }
 
        resultDiv.innerHTML = `<p style="color:red;">No book found with ID ${searchID}</p>`;
    }