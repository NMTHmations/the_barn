import { Fragment } from "react";

function ListGroup() {
  return (
    <Fragment>
      <div className="container-fluid main-body">
        <div className="container-fluid table-body">
          <div className="row table-header">
            <div className="col-sm-2">{"ENAR azonosító"}</div>
            <div className="col-sm-2">{"Állattartó neve"}</div>
            <div className="col-sm-2">{"Tenyészet kódja"}</div>
            <div className="col-sm-2">{"születési dátum"}</div>
            <div className="col-sm-1">{"nem"}</div>
            <div className="col-sm-2">{"fajta, fajtája"}</div>
            <div className="col-sm-1">{"típus"}</div>
          </div>
        </div>
      </div>
    </Fragment>
  );
}

export default ListGroup;
