let collection = require('../models/cat');


const postCat = (req,res) => {
    let cat = req.body;
    console.log(cat);
    collection.postCat(cat, (err,result) => {
        if(!err){
            res.json({statusCode:201,data:result,message:'success'});
        }
    });
}


const getAllCats = (req,res) => {
    collection.getAllCats((err,result)=>{
        console.log(result);
        if(!err){
            res.json({statusCode:200,data:result,message:'success'});
        }
    });
}

const deleteFromDB = (req, res) => {
    let cat = req.body;
    collection.deleteCats(cat, (err, result) => {
        if (!err) {
            res.json({
                statusCode: 202,
                data: result,
                message: 'Deleted...!'
            });

        }
    });
}

module.exports = {postCat, getAllCats, deleteFromDB}