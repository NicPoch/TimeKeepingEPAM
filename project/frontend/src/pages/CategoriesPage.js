import NewCategory from "../components/NewCategory";
import categoriesData from "../data/categoriesData";

const CategoriesPage = ()=>{
    console.log(categoriesData);
    return<>
            <section className="table-info two-sections__section1">
                <table>
                <tr><th>ID</th><th>Name</th> <th>Description</th> <th>Action</th></tr>
                {categoriesData.map((categoryObj) => <tr><td>{categoryObj.id}</td><td>{categoryObj.name}</td> <td>{categoryObj.description}</td> <td><button className="table__button button--delete" onClick={()=>{console.log(categoryObj.id)}}>Delete</button></td></tr>)}
                </table>
            </section>
            <section className="two-sections__section2">
                <NewCategory/>
            </section>
        </>
};

export default CategoriesPage;