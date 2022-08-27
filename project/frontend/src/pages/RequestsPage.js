import requestsData from "../data/requestsData";

const RequestsPage = () => {
    console.log(requestsData);
    return<section className="table-info">
    <table>
    <tr><th>ID</th><th>Username</th> <th>Activity</th> <th>Type of request</th><th>Action</th></tr>
    {requestsData.map((requestObj) => <tr><td>{requestObj.id}</td><td>{requestObj.username}</td> <td>{requestObj.activityName}</td> <td>{requestObj.type}</td><td><button className="table__button button--delete" onClick={()=>{console.log(requestObj.id)}}>Reject</button><button className="table__button button--behaviour">Accept</button></td></tr>)}
</table>
</section>;
}

export default RequestsPage;