
const process={
    getList : function (data){
        console.log('process getList탐 >>>', );
        let getData = data.data.result;
        let array=[];
        let result = {
            name :'',
            email:''
        }
//0 : {no: 20, name: 'Brian Kim1', email: 'test@naver.com', pwd: '1234', gender: true, …}
        for(let i=0; i<getData.length; i++){
           this.result.name = getData[i].name;
           this.result.email = getData[i].email;
           array.push(result);
        }
        return array;
    }
}

export default process;
