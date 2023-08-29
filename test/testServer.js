const { expect } = require("chai");
const request = require("request");
let url = 'http://localhost:3000/api/cat';
let cat = {
    title:'',
    subTitle:'',
    description:'',
    path:''
};

describe('test GET api', function(){
    it('returns statusCode of 200', function(done){
        request(url , function(error,response,bodyString){
            //console.log(arguments);
            
            let bodyObj = JSON.parse(bodyString);
            expect(bodyObj.statusCode).to.equal(200);
            done();
        });
    });
});

describe('test POST api', function(){
    it('post cat to DB', function(done){
        request.post({url:url,form:cat},function(a,b,c){
            let bodyObj = JSON.parse(c);
            expect(bodyObj.message).to.equal('success')
            done()
        })
    })
})

describe("test delete api", function() {
    it("delete cat from db", function(done) {
        request.delete({url: url, form: cat}, function(err, res, body) {
            //console.log(arguments);
            
            done();
        });
    });
});



