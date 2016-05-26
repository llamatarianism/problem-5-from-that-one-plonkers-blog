// nobody told me this was a clojure directory!

const fs = require("fs")

fs.readFile("for-node.txt", "utf8", (err, data) => {
  if (err) throw err;
  const eachLine = data.split("\n");
  const sumsTo100 = eachLine.filter(exp => eval(exp) === 100);
  sumsTo100.forEach(exp => console.log(exp, "== 100"));
})
