import usersData from "../data/usersData";

const UsersPage = () =>{
    <table>
        <tr><th>ID</th><th>Username</th> <th>Name</th> <th>Mail</th><th>Action</th></tr>
        {usersData.map((userObj) => <tr><td>{userObj.id}</td><td>{userObj.username}</td> <td>{userObj.name}</td> <td>{userObj.mail}</td><td><button className="table__button button--delete" onClick={()=>{console.log(userObj.id)}}>Delete</button><button className="table__button button--behaviour">Convert admin</button></td></tr>)}
    </table>
    console.log(usersData);
    
    return<section className="table-info">
        <table>
        <tr><th>ID</th><th>Username</th> <th>Name</th> <th>Mail</th><th>Action</th></tr>
        {usersData.map((userObj) => <tr><td>{userObj.id}</td><td>{userObj.username}</td> <td>{userObj.name}</td> <td>{userObj.mail}</td><td><button className="table__button button--delete" onClick={()=>{console.log(userObj.id)}}>Delete</button><button className="table__button button--behaviour">Convert admin</button></td></tr>)}
    </table>
    </section>;
};
export default UsersPage;