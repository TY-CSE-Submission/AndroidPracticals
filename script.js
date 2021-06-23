//requiring path and fs modules
const path = require("path");
const fs = require("fs");
// const merge = require("easy-pdf-merge");

const PDFMerger = require("pdf-merger-js");

var merger = new PDFMerger();

//joining path of directory
const directoryPath = path.join(__dirname, "");

var walk = function (dir, done) {
  var results = [];
  fs.readdir(dir, function (err, list) {
    if (err) return done(err);
    var i = 0;
    (function next() {
      var file = list[i++];
      if (!file) return done(null, results);
      file = path.resolve(dir, file);
      fs.stat(file, function (err, stat) {
        if (stat && stat.isDirectory()) {
          walk(file, function (err, res) {
            results = results.concat(res);
            next();
          });
        } else {
          results.push(file);
          next();
        }
      });
    })();
  });
};

const callWalk = () => {
  walk(directoryPath, function (err, results) {
    if (err) throw err;
    let relativePaths = [];
    results = results.filter((val, idx) => {
      let [name, ext] = val.split(".");
      if (ext === "pdf") {
        console.log(path.relative("./", val));
        let relativePath = path.relative("./", val);
        relativePaths.push(relativePath);
        return true;
      }
      return false;
    });
    relativePaths = relativePaths.filter(
      (val) => val.indexOf("node_modules") !== 0
    );
    //   console.log(results);
    relativePaths.forEach((val, idx) => {
      let p = "./" + val;
      p.replace(/^.*\\\\.*$/i, "/");
      relativePaths[idx] = p;
      merger.add(p);
    });
    console.log(relativePaths);
    (async () => {
      await merger.save("merged.pdf"); //save under given name and reset the internal document
    })();
  });
};

if (fs.existsSync("merged.pdf")) {
  fs.unlink("merged.pdf", (err) => {
    if (err) {
      console.error("Unable to delete Merged.pdf file");
    } else {
      console.log("Deleted Merged.pdf file before merging");
      callWalk();
    }
  });
} else {
  callWalk();
}
