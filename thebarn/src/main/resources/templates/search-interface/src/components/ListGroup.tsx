import { Fragment } from "react";

function ListGroup() {
  let items = ["aaa", "bbb", "ccc", "ddd"];
  items = [];

  return (
    <Fragment>
      {/*items.length === 0 && <p>nincs találat</p>*/}
      {items.map((item) => (
        <ul className="list-group">
          <li className="list-group-item" key={item}>
            {item}
          </li>
        </ul>
      ))}
    </Fragment>
  );
}

export default ListGroup;
