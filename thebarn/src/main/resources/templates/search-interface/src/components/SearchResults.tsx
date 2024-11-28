import { Fragment } from "react";

function SearchResults() {
  return (
    <Fragment>
      <div className="container-fluid">
        <div className="container-fluid table-body">
          <div className="row table-row">
            <div className="col-sm-2">{"enar"}</div>
            <div className="col-sm-2">{"állattartó neve"}</div>
            <div className="col-sm-2">{"tenyészetkód"}</div>
            <div className="col-sm-2">{"szül.dátum"}</div>
            <div className="col-sm-1">{"nem"}</div>
            <div className="col-sm-2">{"fajta"}</div>
            <div className="col-sm-1">{"típus"}</div>
          </div>
        </div>
      </div>
    </Fragment>
  );
}

export default SearchResults;
