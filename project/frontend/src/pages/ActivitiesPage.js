import activitiesData from "../data/activitiesData";
import ActivityInspector from "../components/ActivityInspector";
const ActivitiesPage = ()=>{
    console.log(activitiesData);
    return<>
    <section className="table-info two-sections__section1">
        <table>
        <tr><th>ID</th><th>Activity</th> <th>Assignee</th> <th>Status</th><th>Action</th></tr>
        {activitiesData.map((activityObj) => <tr><td>{activityObj.id}</td><td>{activityObj.name}</td> <td>{activityObj.assignee}</td><td>{activityObj.status}</td> <td><button className="table__button button--behaviour" onClick={()=>{console.log(activityObj.id)}}>Inspect</button></td></tr>)}
        </table>
    </section>
    <section className="two-sections__section2">
        <ActivityInspector/>
    </section>
</>
};

export default ActivitiesPage;